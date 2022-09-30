package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Camino;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;
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
		maze = new ArrayList<>();
		return game.getCurrentMaze();
		
	}
	public void getPills(Game game, Maze maze) {
		for(Integer i = 0;i < game.getNumberOfActivePills(); i++) {
		Integer eachPillPos = game.getPillIndex(i);
		pillPos.add(eachPillPos);
		}
		
	}
	public void getPowerPills(Game game, Maze maze) {
		for(Integer i = 0;i < game.getNumberOfActivePowerPills(); i++) {
		Integer eachPowerPillPos = game.getPowerPillIndex(i);
		powerPillPos.add(eachPowerPillPos);
		}
	}
	public void getPMPosition(Game game) {
		pacmanPos = game.getPacmanCurrentNodeIndex();
	}
	public void getGhostsPosition(Game game) {
		for(Integer i = 0;i < game.getnu(); i++) {
			Integer eachPowerPillPos = game.getPowerPillIndex(i);
			powerPillPos.add(eachPowerPillPos);
			}
	}
}