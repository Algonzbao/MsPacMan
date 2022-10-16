package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.util.RandomGenerator;
import pacman.controllers.GhostController;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class Ghosts extends GhostController {
	
	private static final String TEAM_ID = "09";
	
	public Ghosts() {
		super();
		setName("PowerRangers" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST,MOVE>(GHOST.class);
		for (GHOST ghost : GHOST.values()) {
			if (game.doesGhostRequireAction(ghost)) {
				MOVE move = RandomGenerator.getMove();
				moves.put(ghost, move);
			}
		}
		return moves;
	}
}
