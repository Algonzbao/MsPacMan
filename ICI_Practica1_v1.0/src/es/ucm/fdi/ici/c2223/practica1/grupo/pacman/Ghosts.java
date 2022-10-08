package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import pacman.game.Game;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher.Launcher;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher.Timer;
import pacman.controllers.GhostController;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class Ghosts extends GhostController {
	
	private static final String TEAM_ID = "09";
	private Launcher launcher;
	private Timer timer;
	
	public Ghosts() {
		super();
		setName("Ghosts" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		if (timer != null) {
			launcher = new Launcher(game);
			timer = new Timer(new Launcher(game));
		}
		timer.start(timeDue - System.currentTimeMillis());
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST, MOVE>(GHOST.class);
		for (Agente a : Agente.values()) {
			GHOST g = a.getGhost();
			if (g != null)
				moves.put(g, launcher.getNextMove(a));
		}
		return moves;
	}
}