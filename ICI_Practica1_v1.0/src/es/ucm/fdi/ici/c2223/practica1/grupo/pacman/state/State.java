package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import pacman.game.internal.Ghost;
import pacman.game.internal.Maze;

public class State {
	private Integer pacmanPos;
	private List<Integer> ghostPos;
	private Map<Camino, Integer> pillPos;
	private Pair<Camino, Integer> powerPillPos;
	private final List<Camino> maze;
	
	public final Maze getMaze(Game game) {
		//this.maze = game.getCurrentMaze();
	}
	public void getPills(Game game, Camino camino) {
		int[] data = game.getActivePillsIndices();
		for(int i = 0; i < game.getActivePillsIndices().length; i++) {
			pillPos.put(camino, data[i]);
		}
	}
	public void getPowerPills(Game game, Camino camino) {
		int[] data = game.getActivePowerPillsIndices();
		for(int i = 0; i < game.getActivePowerPillsIndices().length; i++) {
			powerPillPos.setFirst(camino);
			powerPillPos.setSecond(data[i]);
		}
	}
	public void getPMPosition(Game game) {
		pacmanPos = game.getPacmanCurrentNodeIndex();
	}
	
	public void getGhostsPosition(Game game) {
		ArrayList<Integer> eachGhostPos = new ArrayList<>();
		for (GHOST ghostType : GHOST.values()) {
			eachGhostPos.add(game.getGhostCurrentNodeIndex(ghostType));
		}
	}
}