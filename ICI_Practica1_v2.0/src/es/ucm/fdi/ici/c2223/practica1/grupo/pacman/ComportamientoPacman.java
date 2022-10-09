package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.directivas.Directiva;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.directivas.DirectivaList;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.MOVE;

public class ComportamientoPacman {

	public static MOVE getMove() {
		for (Directiva d : DirectivaList.getDirectivas()) {
			MOVE m = d.getMove();
			if (m != null)
				return m;
		}
	}
}
