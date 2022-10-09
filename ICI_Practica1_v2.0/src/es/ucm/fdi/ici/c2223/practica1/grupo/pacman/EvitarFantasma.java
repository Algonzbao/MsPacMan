package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import pacman.controllers.PacmanController;
=======
import java.util.HashMap;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives.PacmanDirective;
>>>>>>> Stashed changes:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/EvitarFantasma.java
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
	
public class EvitarFantasma extends PacmanDirective {
	
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
			if(GameContainer.get().isGhostEdible(ghostType)) {
				ghostPositions[i]=GameContainer.get().getGhostCurrentNodeIndex(ghostType);
				map.put(ghostPositions[i], ghostType);
				i++;
			}
		}
		//revisar el nodo más cercano
		int pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int closestNode = GameContainer.get().getClosestNodeIndexFromNodeIndex(pacmanIndex, ghostPositions, DM.PATH);
		
		GHOST closestEat=null;
		//si el fantasma está a la distacia más allá del límite que he establecido entonces no llego, en caso de que esté dentro del rango ese es el más cercano
		for (GHOST ghostType : GHOST.values()) {
			if(game.getDistance(closestNode,game.getPacmanCurrentNodeIndex(),DM.PATH)==closestNode && game.getGhostCurrentNodeIndex(ghostType) <= limit) {
				closestEat = ghostType;
				break;
			}
		}
		return closestEat;
	}
	
	private boolean isThereCloserGhost(GHOST nearestGhost) {
		if (GameContainer.get().getDistance(closestNode, pacmanIndex, dm) <= limit)
			closestEat = map.get(closestNode);
		return closestEat;
	}
}
