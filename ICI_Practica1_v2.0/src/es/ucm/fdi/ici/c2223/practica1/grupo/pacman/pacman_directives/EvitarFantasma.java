package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class EvitarFantasma extends Directiva {

	@Override
	public MOVE getMove() {
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
	}
}
