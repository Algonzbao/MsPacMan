package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.directivas;

import java.util.HashMap;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;


public class IrPuntoMedioConPacman extends Directiva {
	private final int GHOSTS_NUMBER = 4;
	@Override
	public MOVE getMove() {
		Map<GHOST, Double> HalfWay = new HashMap<>();
		int [] ghostPositions = new int[GHOSTS_NUMBER];
		int i=0;
		for (GHOST ghostType : GHOST.values()) {
			ghostPositions[i]= GameContainer.get().getGhostCurrentNodeIndex(ghostType);
			Integer pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
			Integer closestNode = GameContainer.get().getClosestNodeIndexFromNodeIndex(pacmanIndex,ghostPositions, DM.PATH);
			Double distance = GameContainer.get().getDistance(closestNode, GameContainer.get().getPacmanCurrentNodeIndex(),DM.PATH); 
			HalfWay.put(ghostType, distance/2);
			GameContainer.get()
			GameContainer.get().getApproximateNextMoveAwayFromTarget(ghostPositions[i], pacmanIndex, GameContainer.get().getGhostLastMoveMade(ghostType), DM.PATH);
			i++;
		}
		return null;
	}
	//camino desde el nodo delante de pacman/ camino minimo entre los dos/ ir al punto medio 
}
