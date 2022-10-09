package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.calculate.Calculator;
import pacman.controllers.PacmanController;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class MsPacMan extends PacmanController {
	
	private static final String TEAM_ID = "09";
	
	public MsPacMan() {
		super();
		setName("MsPacMan" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public MOVE getMove(Game game, long timeDue) {
		return Calculator.getNextMove(Agente.PACMAN);
	}
	public MOVE getMove(Game game, long timeDue) {
		this.game=game;
		
		//si hay fantasmas comestibles y son el mas cercano los priorizamos porque son la fuente principal de puntos
		GHOST edibleGhost = getNearestEdibleGhost(GHOSTS_VISIBILITY_FOLLOW_LIMIT);
		if(edibleGhost != null && notExistAnyCloserGhost(edibleGhost)) {
			return game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(edibleGhost), game.getPacmanLastMoveMade(), DM.PATH);
		}
		
		//si no huimos por las rutas sin fantasmas hacia pills o powerpills (si quedan)
		else {
			return runAway();
		}
	}
}