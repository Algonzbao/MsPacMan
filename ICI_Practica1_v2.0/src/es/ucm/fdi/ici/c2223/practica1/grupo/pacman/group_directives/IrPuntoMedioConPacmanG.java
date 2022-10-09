package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives.IrPuntoMedioConPacman;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class IrPuntoMedioConPacmanG extends GroupDirective {

	@Override
	public EnumMap<GHOST, MOVE> getMoves() {
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST,MOVE>(GHOST.class);
		for (GHOST ghostType : GHOST.values()) {
			if (GameContainer.get().doesGhostRequireAction(ghostType))
				moves.put(ghostType, new IrPuntoMedioConPacman().getMove(ghostType));
		}
		return moves;
	}
}
