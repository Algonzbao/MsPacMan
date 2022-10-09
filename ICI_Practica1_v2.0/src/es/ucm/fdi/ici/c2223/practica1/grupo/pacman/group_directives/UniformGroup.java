package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives;

import java.util.EnumMap;

import javax.lang.model.element.ModuleElement.Directive;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.MyRandom;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra.Calculator;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives.EvitarPacman;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class EvitarPacmanG extends GroupDirective {

	private Directive gd;
	@Override
	public EnumMap<GHOST, MOVE> getMoves() {
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST,MOVE>(GHOST.class);
		MOVE[] allMoves = MOVE.values();
		for (GHOST ghostType : GHOST.values()) {
			if (GameContainer.get().doesGhostRequireAction(ghostType))
				moves.put(ghostType, new EvitarPacman(ghostType));
		}
		return moves;
	}
}
