package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Detective;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class EliminarSeguroPacman extends GhostDirective {

	@Override
	public MOVE getMove(GHOST ghost) {
		if (GameContainer.get().isGhostEdible(ghost))
			return null;
		Integer index = GameContainer.get().getGhostCurrentNodeIndex(ghost);
		MOVE lastMove = GameContainer.get().getGhostLastMoveMade(ghost);
		MOVE pacmanLastMove = GameContainer.get().getPacmanLastMoveMade();
		
		for (Integer i : GameContainer.get().getNeighbouringNodes(index, lastMove)) {
			MOVE move = GameContainer.get().getNextMoveTowardsTarget(index, i, DM.PATH);
			Integer nextJunction = Detective.nextJunction(i, move);
			if (Detective.isInTheWay(nextJunction, index, i, pacmanLastMove))
				return move;
		}
		return null;
	}
}