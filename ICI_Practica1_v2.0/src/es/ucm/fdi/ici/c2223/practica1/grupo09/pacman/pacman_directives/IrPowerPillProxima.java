package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;

public class IrPowerPillProxima extends PacmanDirective {

	@Override
	public MOVE getMove() {
		MOVE lastMoveMade = GameContainer.get().getPacmanLastMoveMade();
		int fromNodeIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int toNodeIndex = 0;
		int minDistance = Integer.MAX_VALUE;
		int[] powerPills = GameContainer.get().getActivePowerPillsIndices();
		if (powerPills.length == 0)
			return null;
		for (int index : GameContainer.get().getActivePowerPillsIndices()) {
			int distance = GameContainer.get().getShortestPathDistance(fromNodeIndex, index, lastMoveMade);
			if (distance < minDistance) {
				toNodeIndex = index;
				minDistance = distance;
			}
		}
		DM distanceMeasure = DM.PATH;
		return GameContainer.get().getApproximateNextMoveTowardsTarget(fromNodeIndex, toNodeIndex, lastMoveMade, distanceMeasure);
	}
}
