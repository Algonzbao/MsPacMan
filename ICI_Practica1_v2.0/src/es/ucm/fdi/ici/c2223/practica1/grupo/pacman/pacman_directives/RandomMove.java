package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.MyRandom;
import pacman.game.Constants.MOVE;

public class RandomMove extends PacmanDirective {
	
	@Override
	public MOVE getMove() {
		MOVE[] allMoves = MOVE.values();
		return allMoves[MyRandom.rnd.nextInt(allMoves.length)];
	}
}
