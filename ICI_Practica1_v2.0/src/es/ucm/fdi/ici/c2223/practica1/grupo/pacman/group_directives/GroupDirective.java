package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives;

import java.util.EnumMap;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public abstract class GroupDirective {

	public abstract EnumMap<GHOST, MOVE> getMoves();
}
