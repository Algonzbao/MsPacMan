package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.directivas;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;

public class IrPowerPillProxima extends Directiva {

	@Override
	public MOVE getMove() {
		GameContainer.get().getApproximateNextMoveTowardsTarget(0, 0, getMove(), null);
		MOVE lastMoveMade = GameContainer.get().getPacmanLastMoveMade();
		int fromNodeIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int toNodeIndex = 0;
		int minDistance = Integer.MAX_VALUE;
		for (int index :GameContainer.get().getActivePowerPillsIndices()) {
			int distance = GameContainer.get().getShortestPathDistance(fromNodeIndex, index, lastMoveMade);
			if (distance < minDistance) {
				toNodeIndex = index;
				minDistance = distance;
			}
		}
		DM distanceMeasure = DM.PATH;
		return GameContainer.get().getApproximateNextMoveTowardsTarget(fromNodeIndex, toNodeIndex, getMove(), distanceMeasure);
	}

}
