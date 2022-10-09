package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.calculate.Calculator;
import pacman.controllers.GhostController;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class Ghosts extends GhostController {
	
	private static final String TEAM_ID = "09";
	
	public Ghosts() {
		super();
		setName("Ghosts" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		GameContainer.set(game);
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST, MOVE>(GHOST.class);
		for (Agente a : Agente.ghosts()) {
			GHOST g = a.getGhost();
			if (g != null)
				moves.put(g, Calculator.getNextMove(a));
		}
		return moves;
	}
}