package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.util.Detective;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class IrPuntoMedioConPacman extends GhostDirective {
	
	@Override
	public MOVE getMove(GHOST ghost) {
		if (GameContainer.get().isGhostEdible(ghost))
			return null;
		Integer pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		MOVE pacmanMove = GameContainer.get().getPacmanLastMoveMade();
		Integer nextJunct = Detective.nextJunction(pacmanIndex, pacmanMove);
		Integer ghostIndex = GameContainer.get().getGhostCurrentNodeIndex(ghost);
		MOVE lastMove = GameContainer.get().getGhostLastMoveMade(ghost);
		return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, nextJunct, lastMove, DM.PATH);
	}
	//camino desde el nodo delante de pacman/ camino minimo entre los dos/ ir al punto medio 
}
