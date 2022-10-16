package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link;

import pacman.game.Game;

public class GameContainer {

	private static Game game;
	
	public static Game get() {
		return game;
	}

	public static void set(Game game) {
		GameContainer.game = game;
	}
}