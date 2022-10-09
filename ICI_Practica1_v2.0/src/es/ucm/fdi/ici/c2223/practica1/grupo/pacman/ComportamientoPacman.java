package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.MOVE;

public class ComportamientoPacman {

	public static MOVE getMove() {
		List<MOVE> possibleMoves = GameContainer.get().getPossibleMoves(0, getMove());
		
		for (Directiva d : Directivas) {
			Move m = d.getMove();
			if (m != null)
				return m;
		}
				
	}
}
