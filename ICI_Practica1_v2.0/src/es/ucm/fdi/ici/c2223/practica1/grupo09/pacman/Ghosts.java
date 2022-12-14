package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives.GhostDirective;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives.GhostDirectiveList;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives.RandomMove;
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
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST,MOVE>(GHOST.class);
		for (GHOST ghostType : GHOST.values()) {
			if (GameContainer.get().doesGhostRequireAction(ghostType)) {
				MOVE move = null;
				for (GhostDirective d : GhostDirectiveList.getDirectivas()) {
					move = d.getMove(ghostType);
					if (move != null)
						break;
				}
				if (move == null)
					move = new RandomMove().getMove();
				moves.put(ghostType, move);
			}
		}
		/*
		for (GHOST ghostType : GHOST.values()) {
			if (GameContainer.get().doesGhostRequireAction(ghostType)) {
				System.out.println(moves.get(ghostType).name());
			}
		}
		*/
		return moves;
	}
}
