package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;
import java.util.HashMap;
import java.util.Map;

import pacman.controllers.PacmanController;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
	
public class MsPacManAlex extends PacmanController{
	
	private static final DM dm = DM.PATH;
		private Game game;
		private final int GHOSTS_NUMBER = 4;
		private final int GHOSTS_FOLLOW_LIMIT = 150;
		
	@Override
	public MOVE getMove(Game game, long timeDue) {
		this.game=game;
		
		//Si me puedo comer un fantasma y es el que más cerca tengo de todos me lo como (max puntos)
		GHOST edibleGhost = getNearestEdibleGhost(GHOSTS_FOLLOW_LIMIT);
		if (edibleGhost == null)
			return null;
		if(edibleGhost != null) {
			int pacmanIndex = game.getPacmanCurrentNodeIndex();
			int edibleGhostIndex = game.getGhostCurrentNodeIndex(edibleGhost);
			
			return game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(edibleGhost), game.getPacmanLastMoveMade(), DM.PATH);
		}
	}
	private GHOST getNearestEdibleGhost(int limit) {
		int [] ghostPositions = new int[GHOSTS_NUMBER];
		
		int i=0;
		Map<Integer, GHOST> map = new HashMap<>();
		//guardar la posicion en el mapa de cada uno de los fantasmas comestibles
		for (GHOST ghostType : GHOST.values()) {
			if(game.isGhostEdible(ghostType)) {
				ghostPositions[i]=game.getGhostCurrentNodeIndex(ghostType);
				map.put(ghostPositions[i], ghostType);
				i++;
			}
		}
		//revisar el nodo más cercano
		int closestNode = game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(), ghostPositions, DM.PATH);
		
		GHOST closestEat=null;
		//si el fantasma está a la distacia más allá del límite que he establecido entonces no llego, en caso de que esté dentro del rango ese es el más cercano
		if (game.getDistance(closestNode,game.getPacmanCurrentNodeIndex(),DM.PATH) <= limit)
			closestEat = map.get(closestNode);
		return closestEat;
	}
	
}
