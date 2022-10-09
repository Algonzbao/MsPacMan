package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class PerseguirPacman extends GhostDirective {

	@Override
	public MOVE getMove(GHOST ghost) {
		if (GameContainer.get().isGhostEdible(ghost))
			return null;
		Integer pacIx = GameContainer.get().getPacmanCurrentNodeIndex();
		Integer ghIx = GameContainer.get().getGhostCurrentNodeIndex(ghost);
		MOVE lMove = GameContainer.get().getGhostLastMoveMade(ghost);
		DM dm = DM.PATH;
		return GameContainer.get().getNextMoveTowardsTarget(pacIx, ghIx, lMove, dm);
	}
}
