package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.Advancer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Position;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;

public class Turing {
	
	private final ArbolAlphaBeta aab;
	private List<Pair<Agente, Integer>> list;
	private Map<Agente, Action> transition;
	private List<Map<Agente, Action>> transitions;
	
	public Turing(ArbolAlphaBeta aab) {
		this.aab = aab;
		this.list = new ArrayList<>();
		this.transition = new HashMap<>();
		this.transitions = new ArrayList<>();
		if (!this.aab.isLeaf())
			explore();
	}
	
	private void explore() {
		for (Agente a : Agente.values()) {
			Position position = aab.getState().getPosition(a);
			if (position.isInTheEnd())
				list.add(new Pair<Agente, Integer>(a, position.getCamino().getNumNextCaminos()));
		}
		conmutate(0);
		for (Map<Agente, Action> transition : transitions) {
			Advancer advancer = new Advancer(aab.getState(), transition);
			ArbolAlphaBeta son = advancer.createSon(this.aab);
			aab.addSon(transition, son);
		}
	}
	
	private void conmutate(int iAgente) {
		final Pair<Agente, Integer> elem = list.get(iAgente);
		final Agente agente = elem.getFirst();
		final int N_ACTIONS = elem.getSecond();
		for (int i = 0; i < N_ACTIONS; i++) {
			transition.put(agente, Action.id(i));
			if (list.size() == ++iAgente)
				transitions.add(Map.copyOf(transition));
			else
				conmutate(iAgente);
		}
	}
}
