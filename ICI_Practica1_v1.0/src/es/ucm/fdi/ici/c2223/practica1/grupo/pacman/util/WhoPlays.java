package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;

public class WhoPlays {

	public static Pair<Boolean, Boolean> checkWhoPlays(State state) {
		Boolean willPacmanPlay = state.getPosition(Agente.PACMAN).isInTheEnd();
		Boolean willGhostPlay = false;
		for (Agente agente : Agente.values()) {
			if (agente != Agente.PACMAN && state.getPosition(agente).isInTheEnd())
				willGhostPlay = true;
		}
		return new Pair<>(willPacmanPlay, willGhostPlay);
	}
}