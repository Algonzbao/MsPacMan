package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives;

import java.util.HashMap;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class EliminarFantasma extends PacmanDirective {
	
	private static final DM dm = DM.PATH;
	private final int GHOSTS_NUMBER = 4;
	private final int GHOSTS_FOLLOW_LIMIT = 150;
	
	@Override
	public MOVE getMove() {
		//Si me puedo comer un fantasma y es el que más cerca tengo de todos me lo como (max puntos)
		GHOST edibleGhost = getNearestEdibleGhost(GHOSTS_FOLLOW_LIMIT);
		if (edibleGhost == null)
			return null;
		int pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int edibleGhostIndex = GameContainer.get().getGhostCurrentNodeIndex(edibleGhost);
		MOVE pacLastMove = GameContainer.get().getPacmanLastMoveMade();
		return GameContainer.get().getApproximateNextMoveTowardsTarget(pacmanIndex, edibleGhostIndex, pacLastMove, dm);
	}
	
	private GHOST getNearestEdibleGhost(int limit) {
		int [] ghostPositions = new int[GHOSTS_NUMBER];
		int i=0;
		Map<Integer, GHOST> map = new HashMap<>();
		
		//guardar la posicion en el mapa de cada uno de los fantasmas comestibles
		for (GHOST ghostType : GHOST.values()) {
			if (GameContainer.get().isGhostEdible(ghostType)) {
				ghostPositions[i] = GameContainer.get().getGhostCurrentNodeIndex(ghostType);
				map.put(ghostPositions[i], ghostType);
				i++;
			}
		}
		
		//revisar el nodo más cercano
		int pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int closestNode = GameContainer.get().getClosestNodeIndexFromNodeIndex(pacmanIndex, ghostPositions, DM.PATH);
		
		GHOST closestEat = null;
		if (GameContainer.get().getDistance(closestNode, pacmanIndex, dm) <= limit)
			closestEat = map.get(closestNode);
		return closestEat;
	}
}
