package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class GameObserver {

	public static MOVE getLastMove(Agente a) {
		switch (a) {
		case PACMAN :
			return GameContainer.get().getPacmanLastMoveMade();
		case GHOST1 :
			return GameContainer.get().getGhostLastMoveMade(GHOST.BLINKY);
		case GHOST2 :
			return GameContainer.get().getGhostLastMoveMade(GHOST.INKY);
		case GHOST3 :
			return GameContainer.get().getGhostLastMoveMade(GHOST.PINKY);
		case GHOST4 :
			return GameContainer.get().getGhostLastMoveMade(GHOST.SUE);
		}
		return null;
	}
}
