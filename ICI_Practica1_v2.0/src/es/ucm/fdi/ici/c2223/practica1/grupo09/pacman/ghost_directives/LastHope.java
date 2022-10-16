package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class LastHope extends GhostDirective {
	private Integer LIMIT_PILLS = 40;
	@Override
	public MOVE getMove(GHOST ghost) {
		Integer ghostIndex = GameContainer.get().getGhostCurrentNodeIndex(ghost);
		MOVE lastMove = GameContainer.get().getGhostLastMoveMade(ghost);
		Integer pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		if(GameContainer.get().getNumberOfActivePills() <= LIMIT_PILLS) {
			Integer actPPills = GameContainer.get().getNumberOfActivePowerPills();
			int[] pPillPlace = GameContainer.get().getActivePowerPillsIndices();
			//si solo hay 1 pill ir todos al rededor de ella
			//en caso de llegar al index de la pill volver a la casilla de salida y volver a por la pill
			if(actPPills == 1) {
				 	if(ghostIndex == pPillPlace[0]){
				 		return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, GameContainer.get().getGhostInitialNodeIndex(), lastMove, DM.PATH);
				 	}
				 	else if(ghostIndex == GameContainer.get().getGhostInitialNodeIndex()) {
				 		return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, pPillPlace[0], lastMove, DM.PATH);
				 	}	 	
			}
			//si hay mas de una ir a cubrir la más cercana a pacaman
			else if (actPPills > 1){
				Integer smallerSpace = Integer.MAX_VALUE;
					for(int i= 0; i < pPillPlace.length; i++) {
						Integer closestPillIndex = GameContainer.get().getClosestNodeIndexFromNodeIndex(ghostIndex, pPillPlace, DM.PATH);
							if(closestPillIndex < smallerSpace) {
								smallerSpace = closestPillIndex;
							}
						}
					if(ghostIndex == GameContainer.get().getGhostInitialNodeIndex()){
						return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, smallerSpace, lastMove, DM.PATH);
					}
					else {
						return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, GameContainer.get().getGhostInitialNodeIndex(), lastMove, DM.PATH);
						}
					}
			}
		// si no queda ninguna ir a por pacman directamente
			else {
				return GameContainer.get().getNextMoveTowardsTarget(ghostIndex, pacmanIndex, lastMove, DM.PATH);
				
			}
		return null;
	}

}
