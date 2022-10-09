package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher;

import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.ArbolAlphaBeta;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.PriorityAnalyzer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Transition;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameConverter;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameObserver;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.WhoPlays;
import pacman.game.Constants.MOVE;
import pacman.game.internal.Maze;
import pacman.game.Game;

public class Launcher implements TimeObject {
	
	private Maze maze;
	private final GameObserver gameObserver;
	private final PriorityAnalyzer priorityAnalyzer;
	private ArbolAlphaBeta aab;
	
	public Launcher(Game game) {
		this.gameObserver = new GameObserver();
		this.priorityAnalyzer = new PriorityAnalyzer();
	}
	
	public void run() {
		Maze actualMaze = GameContainer.get().getCurrentMaze();
		if (actualMaze == this.maze) initGame();
		else update();
		priorityAnalyzer.run();
	}
	
	private void initGame() {
		gameObserver.initLabyrinth();
		State actualState = gameObserver.getActualState();
		Pair<Boolean, Boolean> pair = WhoPlays.checkWhoPlays(gameObserver.getActualState());
		Boolean isPacmanPlay = pair.getFirst();
		Boolean isGhostPlay = pair.getSecond();
		this.aab = new ArbolAlphaBeta(actualState, false, isPacmanPlay, isGhostPlay, 0, null, null, actualState.getEasyAdvanceTime());
	}
	
	private void update() {
		if (!aab.tryEasyAdvance())
			aab = aab.getSon(this.gameObserver.getTransition());
	}
	
	public void stop() {
		priorityAnalyzer.stop();
	}
	
	public MOVE getNextMove(Agente agente) {
		return aab.getBestMove(agente);
	}
}