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
		return ComportamientoPacman.getMove();
	}
}
