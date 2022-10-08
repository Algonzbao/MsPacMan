package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class GameConverter {

	private final Game game;
	
	public GameConverter(final Game game) {
		this.game = game;
	}
	
	public MOVE convertActionToMOVE(final State actualState, final Agente agente, final Action action) {
		// TODO Falta de implementar.
		return null;
	}
}