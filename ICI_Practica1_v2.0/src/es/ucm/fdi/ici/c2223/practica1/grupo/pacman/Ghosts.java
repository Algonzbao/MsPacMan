package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra.Calculator;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives.GhostsDirectiveList;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives.RandomMoves;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives.PacmanDirective;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives.PacmanDirectiveList;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives.RandomMove;
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
		for (PacmanDirective d : GhostsDirectiveList.getDirectives()) {
			EnumMap<GHOST, MOVE> moves = d.getMoves();
			if (moves != null)
				return moves;
		}
		return new RandomMoves().getMoves();
	}
}