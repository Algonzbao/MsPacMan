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
		this.maze = new ArrayList<>();
		this.agentsPosition = new HashMap<>();
	}
}
