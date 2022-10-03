package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.List;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Position;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;

public class WhoPlays {

	public static Pair<Boolean, Boolean> checkWhoPlays(State state) {
		Position pacman = state.getPacman();
		List<Position> ghosts = state.getGhosts();
		Boolean willPacmanPlay = pacman.isInTheEnd();
		Boolean willGhostPlay = false;
		for (Position ghost : ghosts) {
			if (ghost.isInTheEnd())
				willGhostPlay = true;
		}
		return new Pair<>(willPacmanPlay, willGhostPlay);
	}
}
