package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;
<<<<<<< Updated upstream:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/MsPacManAlex.java
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
	
<<<<<<< Updated upstream:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/MsPacManAlex.java
public class MsPacManAlex extends PacmanController{
		private Game game;
		private final int GHOSTS_NUMBER = 4;
		private final int GHOSTS_FOLLOW_LIMIT = 150;
		
=======
public class EvitarFantasma extends PacmanDirective {
	
	private static final DM dm = DM.PATH;
	private final int GHOSTS_NUMBER = 4;
	private final int GHOSTS_FOLLOW_LIMIT = 150;
	
>>>>>>> Stashed changes:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/EvitarFantasma.java
	@Override
	public MOVE getMove() {
		//Si me puedo comer un fantasma y es el que más cerca tengo de todos me lo como (max puntos)
		GHOST edibleGhost = getNearestEdibleGhost(GHOSTS_FOLLOW_LIMIT);
<<<<<<< Updated upstream:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/MsPacManAlex.java
		if(edibleGhost != null && !isThereCloserGhost(edibleGhost)) {
			return game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(edibleGhost), game.getPacmanLastMoveMade(), DM.PATH);
		}
		
		//huir
		else {
			return HUIR();
		}
=======
		if (edibleGhost == null)
			return null;
		int pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int edibleGhostIndex = GameContainer.get().getGhostCurrentNodeIndex(edibleGhost);
		MOVE pacLastMove = GameContainer.get().getPacmanLastMoveMade();
		return GameContainer.get().getApproximateNextMoveTowardsTarget(pacmanIndex, edibleGhostIndex, pacLastMove, dm);
>>>>>>> Stashed changes:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/EvitarFantasma.java
	}
	
	private GHOST getNearestEdibleGhost(int limit) {
		int [] ghostPositions = new int[GHOSTS_NUMBER];
		int i=0;
		//guardar la posicion en el mapa de cada uno de los fantasmas comestibles
		for (GHOST ghostType : GHOST.values()) {
<<<<<<< Updated upstream:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/MsPacManAlex.java
			if(game.isGhostEdible(ghostType)) {
				ghostPositions[i]=game.getGhostCurrentNodeIndex(ghostType);
=======
			if(GameContainer.get().isGhostEdible(ghostType)) {
				ghostPositions[i]=GameContainer.get().getGhostCurrentNodeIndex(ghostType);
				map.put(ghostPositions[i], ghostType);
>>>>>>> Stashed changes:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/EvitarFantasma.java
				i++;
			}
		}
		//revisar el nodo más cercano
		int pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
		int closestNode = GameContainer.get().getClosestNodeIndexFromNodeIndex(pacmanIndex, ghostPositions, DM.PATH);
		
		GHOST closestEat=null;
		//si el fantasma está a la distacia más allá del límite que he establecido entonces no llego, en caso de que esté dentro del rango ese es el más cercano
<<<<<<< Updated upstream:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/MsPacManAlex.java
		for (GHOST ghostType : GHOST.values()) {
			if(game.getDistance(closestNode,game.getPacmanCurrentNodeIndex(),DM.PATH)==closestNode && game.getGhostCurrentNodeIndex(ghostType) <= limit) {
				closestEat = ghostType;
				break;
			}
		}
		return closestEat;
	}
	
	private boolean isThereCloserGhost(GHOST nearestGhost) {
		//En caso de que exista algún fantasma no comestible más cerca que yo, me escapo
		double nodeDistance = game.getDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(nearestGhost), DM.PATH);
		for(GHOST g: GHOST.values()) {
			if(game.getDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(g), DM.PATH) < nodeDistance &&  g !=nearestGhost && game.isGhostEdible(g) == false) {
				return true;
			}
		}
		return false;
	}
	
=======
		if (GameContainer.get().getDistance(closestNode, pacmanIndex, dm) <= limit)
			closestEat = map.get(closestNode);
		return closestEat;
	}
>>>>>>> Stashed changes:ICI_Practica1_v2.0/src/es/ucm/fdi/ici/c2223/practica1/grupo/pacman/EvitarFantasma.java
}
