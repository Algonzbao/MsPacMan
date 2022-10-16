package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.util;

import java.util.Random;

import pacman.game.Constants.MOVE;

public class RandomGenerator {

	private static Random random;
	
	public static MOVE getMove() {
		if (random == null)
			random = new Random();
		MOVE[] allMoves = MOVE.values();
		return allMoves[random.nextInt(allMoves.length)];
	}
}
