package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Camino;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Position;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;

public class Mutation {

	public Mutation() {
		
	}
	static Map<Agente, Camino> whoInspect(State state) {
		Map<Agente, Camino> map = new HashMap<>();
		for (Agente a : Agente.values()) {
			Position p = state.getPosition(a);
			if (p.isInTheEnd())
				map.put(a, p.getCamino());
		}
		return map;
	}
}
