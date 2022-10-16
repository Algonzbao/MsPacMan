package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class EvitarFantasma extends PacmanDirective {

	private static Double DISTANCE = 15.0;
	
	@Override
	public MOVE getMove() {
		Integer pacIx = GameContainer.get().getPacmanCurrentNodeIndex();
		Integer ghIx;
		Integer chosenGhostIndex = null;
		MOVE lm = GameContainer.get().getPacmanLastMoveMade();
		Double minDistance = Double.MAX_VALUE;
		Double distance;
		for (GHOST ghost : GHOST.values()) {
			if (!GameContainer.get().isGhostEdible(ghost)) {
				ghIx =  GameContainer.get().getGhostCurrentNodeIndex(ghost);
				// distance = GameContainer.get().getShortestPathDistance(pacIx, ghIx, lm);
				distance = GameContainer.get().getDistance(pacIx, ghIx, lm, DM.PATH);
				if (distance < minDistance) {
					minDistance = distance;
					chosenGhostIndex = ghIx;
				}
			}
		}
		if (minDistance < DISTANCE)
			return GameContainer.get().getNextMoveAwayFromTarget(pacIx, chosenGhostIndex, lm, DM.PATH);
		return null;
	}
}
