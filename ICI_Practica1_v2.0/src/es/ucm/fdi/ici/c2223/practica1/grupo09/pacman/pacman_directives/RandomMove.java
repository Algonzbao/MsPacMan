package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.constants.MyRandom;
import pacman.game.Constants.MOVE;

public class RandomMove implements Directive {
	
	@Override
	public MOVE getMove() {
		MOVE[] allMoves = MOVE.values();
		return allMoves[MyRandom.rnd.nextInt(allMoves.length)];
	}
}
