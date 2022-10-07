package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Camino;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.CaminoIdentifier;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Douposition;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Junction;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.JunctionIdentifier;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Labyrinth;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Position;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.internal.Maze;
import pacman.game.internal.Node;

public class GameObserver {
	
	private final Game game;
	private Maze maze;
	
	public GameObserver(final Game game) {
		this.game = game;
	}
	
	public State execute() {
		if (maze == game.getCurrentMaze())
			return update();
		maze = game.getCurrentMaze();
		initLabyrinth();
		return getActualState();
	}
	public State getActualState() {
		// Falta
		return null;
	}
	
	private State update() {
		// Falta
		return null;
	}
	
	public Labyrinth initLabyrinth() {
		List<Camino> caminos = new ArrayList<>();
		// Node[] nodes = maze.graph;
		List<Boolean> explored = new ArrayList<>(Collections.nCopies(maze.graph.length, false));
		List<Node> waitList = new ArrayList<>();
		for (Node node : maze.graph) {
			if (node.numNeighbouringNodes > 2) {
				waitList.add(node);
				break;
			}
		}
		
		while (waitList.size() != 0) {
			Node junctionNode = waitList.get(0);
			waitList.remove(0);
			if (!explored.get(junctionNode.nodeIndex)) {
				explored.set(junctionNode.nodeIndex, true);
				// Junction startJunction = new Junction(JunctionIdentifier.getInstance().newJunction());
				for (MOVE move1 : MOVE.values()) {
					if (junctionNode.neighbourhood.containsKey(move1)) {
						if (!explored.get(junctionNode.neighbourhood.get(move1))) {
							Node nextNode = maze.graph[junctionNode.neighbourhood.get(move1)];
							Node lastNode = junctionNode;
							// public Camino(Integer id, Junction startJunction)
							Integer idCamino = CaminoIdentifier.getInstance().newCamino();
							Integer startJunction = junctionNode.nodeIndex;
							Integer endJunction;
							Integer distanceCamino = 0;
							Integer pillsCamino = 0;
							Integer powerPillPlaceCamino = 0;
							while (nextNode.numNeighbouringNodes <= 2) {
								if (nextNode.pillIndex != -1)
									pillsCamino++;
								if (nextNode.powerPillIndex != -1)
									powerPillPlaceCamino = distanceCamino + 1;
								for (MOVE move2 : MOVE.values()) {
									if (nextNode.neighbourhood.containsKey(move2)) {
										Integer tmpNodeIndex = nextNode.neighbourhood.get(move2);
										if (tmpNodeIndex != lastNode.nodeIndex) {
											lastNode = nextNode;
											nextNode = maze.graph[tmpNodeIndex];
											break;
										}
									}
								}
								distanceCamino++;
							}
							endJunction = nextNode.nodeIndex;
							explored.set(lastNode.nodeIndex, true);
							waitList.add(nextNode);
							caminos.add(new Camino(idCamino, distanceCamino, pillsCamino, powerPillPlaceCamino, startJunction, endJunction));
						}
					}
				}
			}
		}
	}
	
		// donde se guardan los caminos?
		// private final List<Camino> maze;
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
	
	/* Se deben almacenar la lista de transiciones con el fin de eliminar las líneas temporales
	 * alternativas que no han sucedido */
	public Map<Agente, MOVE> inferTransitions(final State state) {
		Map<Agente, MOVE> transition = new HashMap<>();
		Map<Agente, Camino> map = Mutation.whoInspect(state);
		for (Agente a : map.keySet())
			transition.put(a, getLastMove(a));
		return transition;
	}
	//public State(List<Camino> maze, Map<Agente, Position> agentes, List<Douposition> pills, List<Douposition> powerPills, Game game)
	public State advance(State oldState, Map<Agente, MOVE> transition) {
		State state = State.copy(oldState);
		Map<Agente, Position> agentes = new HashMap<>();
		for (Agente a : Agente.values()) {
			if (!state.getPosition(a).isInTheEnd()) {
				Map<Agente, Position> agentes = state.getAgentes();
				Position position = agentes.get(a);
				position.setPlace(position.getPlace()++);
			} else {
				Map<Agente, Position> agentes = state.getAgentes();
				Position position = agentes.get(a);
				Position newPosition;
				Camino newCamino = position.getCamino().getNextCamino(transition.get(a));
				newPosition = new Position(newCamino, 1);
				agentes.remove(a);
				agentes.put(a, newPosition);
			}
	}
	/*
	private Integer observeIndex(Agente a) {
		switch (a) {
		case PACMAN :
			return game.getPacmanCurrentNodeIndex();
		case GHOST1 :
			return game.getGhostCurrentNodeIndex(GHOST.BLINKY);
		case GHOST2 :
			return game.getGhostCurrentNodeIndex(GHOST.INKY);
		case GHOST3 :
			return game.getGhostCurrentNodeIndex(GHOST.PINKY);
		case GHOST4 :
			return game.getGhostCurrentNodeIndex(GHOST.SUE);
		}
		return null;
	}
	*/
	private MOVE getLastMove(Agente a) {
		switch (a) {
		case PACMAN :
			return game.getPacmanLastMoveMade();
		case GHOST1 :
			return game.getGhostLastMoveMade(GHOST.BLINKY);
		case GHOST2 :
			return game.getGhostLastMoveMade(GHOST.INKY);
		case GHOST3 :
			return game.getGhostLastMoveMade(GHOST.PINKY);
		case GHOST4 :
			return game.getGhostLastMoveMade(GHOST.SUE);
		}
		return null;
	}
}
