package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives;

import java.util.HashMap;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class IrPuntoMedioConPacman extends GhostDirective {
	private final int GHOSTS_NUMBER = 4;
	@Override
	public MOVE getMove(GHOST ghost) {
		
			Integer pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
			Integer ghostIndex = GameContainer.get().getGhostCurrentNodeIndex(ghost);
			MOVE lastMove = GameContainer.get().getGhostLastMoveMade(ghost);
			return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, pacmanIndex,lastMove, DM.PATH);
	}
	//camino desde el nodo delante de pacman/ camino minimo entre los dos/ ir al punto medio 
}
