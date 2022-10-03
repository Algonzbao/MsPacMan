package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher;

import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.ArbolAlphaBeta;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.PriorityAnalyzer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameConverter;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameObserver;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.WhoPlays;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class Launcher implements TimeObject {
	
	private final GameObserver gameObserver;
	private final GameConverter gameConverter;
	private final PriorityAnalyzer priorityAnalyzer;
	private ArbolAlphaBeta aab;
	
	public Launcher(Game game) {
		this.gameObserver = new GameObserver(game);
		this.gameConverter = new GameConverter(game);
		this.priorityAnalyzer = new PriorityAnalyzer();
	}
	
	public void run() {
		if (aab == null) initAAB();
		else update();
		priorityAnalyzer.run();
	}
	
	private void initAAB() {
		State actualState = gameObserver.getActualState();
		Pair<Boolean, Boolean> pair = WhoPlays.checkWhoPlays(gameObserver.getActualState());
		Boolean isPacmanPlay = pair.getFirst();
		Boolean isGhostPlay = pair.getSecond();
		this.aab = new ArbolAlphaBeta(actualState, false, isPacmanPlay, isGhostPlay, 0, null, null);
	}
	
	private void update() {
		List<Map<Agente, Action>> transitions = this.gameObserver.inferTransitions(aab.getState());
		for (Map<Agente, Action> transition : transitions)
			aab = aab.getSon(transition);
	}
	
	public void stop() {
		priorityAnalyzer.stop();
	}
	
	public MOVE getNextMove(Agente agente) {
		Map<Agente, Action> actions = aab.getBestNextMoves();
		if (!actions.containsKey(agente))
			return MOVE.NEUTRAL;
		Action action = aab.getBestNextMoves().get(agente);
		return gameConverter.convertActionToMOVE(aab.getState(), agente, action);
	}
}
