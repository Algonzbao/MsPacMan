package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives.PacmanDirective;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives.PacmanDirectiveList;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives.RandomMove;
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
		GameContainer.set(game);
		for (PacmanDirective d : PacmanDirectiveList.getDirectivas()) {
			MOVE m = d.getMove();
			if (m != null)
				return m;
		}
		return new RandomMove().getMove();
	}
}
