package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.constants;

import pacman.game.Constants.GHOST;

public enum Agente {

	PACMAN(null), GHOST1(GHOST.BLINKY), GHOST2(GHOST.INKY), GHOST3(GHOST.PINKY), GHOST4(GHOST.SUE);
	
	public static Agente[] ghosts() {
		return new Agente[] { GHOST1, GHOST2, GHOST3, GHOST4 };
	}
	
	private GHOST ghost;
	
	private Agente(GHOST ghost) {
		this.ghost = ghost;
	}
	public GHOST getGhost() {
		return ghost;
	}
}