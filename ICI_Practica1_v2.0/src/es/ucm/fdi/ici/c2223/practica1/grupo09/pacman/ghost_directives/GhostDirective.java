package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public abstract class GhostDirective {

	public abstract MOVE getMove(GHOST ghost);
}
