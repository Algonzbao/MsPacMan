package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher.Launcher;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher.Timer;
import pacman.controllers.PacmanController;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class MsPacMan extends PacmanController {
	
	private static final String TEAM_ID = "09";
	private Launcher launcher;
	private Timer timer;
	
	public MsPacMan() {
		super();
		setName("MsPacMan" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public MOVE getMove(Game game, long timeDue) {
		if (timer != null) {
			launcher = new Launcher(game);
			timer = new Timer(new Launcher(game));
		}
		timer.start(timeDue - System.currentTimeMillis());
		return launcher.getNextMove(Agente.PACMAN);
	}
}
