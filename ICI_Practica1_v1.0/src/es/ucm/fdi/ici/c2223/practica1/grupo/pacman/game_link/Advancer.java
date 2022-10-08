package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.ArbolAlphaBeta;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.WhoPlays;

public class Advancer {

	private final Map<Agente, Action> transition;
	private State nextState;
	private Boolean willBeLeaf;
	private Boolean willPacmanPlay;
	private Boolean willGhostPlay;
	private Integer newPoints;
	
	public Advancer(State state, Map<Agente, Action> transition) {
		this.transition = transition;
		calculate(state);
	}
	private void calculate(State state) {
		/* TODO Falta por implementar. Averiguar e inicializar:
		 * - State nextState;
		 * - Boolean willBeLeaf;
		 * - Integer newPoints;
		 */
		checkWhoPlays();
	}
	private void checkWhoPlays() {
		Pair<Boolean, Boolean> pair = WhoPlays.checkWhoPlays(nextState);
		this.willPacmanPlay = pair.getFirst();
		this.willGhostPlay = pair.getSecond();
	}

	public ArbolAlphaBeta createSon(ArbolAlphaBeta aab) {
		return new ArbolAlphaBeta(nextState, willBeLeaf, willPacmanPlay, willGhostPlay, newPoints, transition, aab);
	}
}