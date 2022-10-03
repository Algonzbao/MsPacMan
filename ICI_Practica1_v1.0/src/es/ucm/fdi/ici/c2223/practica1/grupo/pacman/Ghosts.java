package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import pacman.game.Game;

import java.util.EnumMap;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher.Launcher;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher.Timer;
import pacman.controllers.GhostController;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class Ghosts extends GhostController implements TimeObject {

	private Game game;
	private Timer timer;
	private Launcher launcher;
	private EnumMap<GHOST, MOVE> moves;
	
	@Override
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		this.game = game;
		if (timer != null)
			timer = new Timer(this);
		timer.start();
		return moves;
	}
	
	public void activate() {
		if (launcher != null)
			launcher = new Launcher(game);
		launcher.run();
		EnumMap<GHOST, MOVE> moves = new EnumMap<GHOST, MOVE>(GHOST.class);
		for (Agente a : Agente.values()) {
			GHOST g = a.getGhost();
			if (g != null)
				moves.put(g, launcher.getNextMove(a));
		}
	}

	@Override
	public void stop() {
		launcher.stop();
		this.moves = new EnumMap<GHOST, MOVE>(GHOST.class);
		for (Agente a : Agente.values()) {
			GHOST g = a.getGhost();
			if (g != null)
				moves.put(g, launcher.getNextMove(a));
		}
	}
}
