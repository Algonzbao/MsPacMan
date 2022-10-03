package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import pacman.game.Game;

public class GameObserver {

	private final Game game;
	
	public GameObserver(final Game game) {
		this.game = game;
	}
	
	public State getActualState() {
		// TODO Falta de implementar.
		return null;
	}

	public List<Map<Agente, Action>> inferTransitions(final State state) {
		// TODO Falta de implementar.
		return null;
	}
}
