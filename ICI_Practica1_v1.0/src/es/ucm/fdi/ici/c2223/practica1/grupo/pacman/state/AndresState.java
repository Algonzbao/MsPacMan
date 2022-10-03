package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import pacman.game.internal.Ghost;
import pacman.game.internal.Maze;

public class State {
	
	private final Game game;
	private final List<Camino> maze;
	private Map<Agente, Position> agentsPosition;
	private List<Position> agentes;
	private Position pacman;
	private List<Position> ghosts;
	private List<Douposition> pills;
	private List<Douposition> powerPills;
	
	public State(Game game) {
		this.game = game;
		updateGhostPosition();
		this.maze = new ArrayList<>();
		this.agentsPosition = new HashMap<>();
		updateAgentsPosition();
		initMaze();
	}
	
	
	public Game getGame() {
		return game;
	}


	public List<Camino> getMaze() {
		return maze;
	}


	public Position getPacman() {
		return pacman;
	}


	public List<Position> getGhosts() {
		return ghosts;
	}


	public List<Douposition> getPills() {
		return pills;
	}


	public List<Douposition> getPowerPills() {
		return powerPills;
	}


	private void updateAgentsPosition() {
		this.game.getPacmanCurrentNodeIndex()
		agentsPosition.put(Agente.PACMAN, this.game.getPacmanCurrentNodeIndex());
		for (GHOST g : GHOST.values())
			ghostPosition.add(game.getGhostCurrentNodeIndex(g));
	}
	private void updateGhostPosition() {
		for (GHOST g : GHOST.values())
			ghostPosition.add(game.getGhostCurrentNodeIndex(g));
	}
	
	private void initMaze() {
		Maze maze = game.getCurrentMaze();
		// TODO Falta inicializar _maze
	}
	
	public final Maze getMaze(Game game) {
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
	
	public Position getPosition(Agente a) {
		return this.agentsPosition.get(a);
	}
}
