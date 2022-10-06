package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Camino;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.CaminoIdentifier;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Junction;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.JunctionIdentifier;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Labyrinth;
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
	
	public void execute() {
		if (maze == game.getCurrentMaze())
			update();
		maze = game.getCurrentMaze();
	}
	public State getActualState() {
		tryInitState();
		return null;
	}
	
	private void update() {}
	
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
				Junction startJunction = new Junction(JunctionIdentifier.getInstance().newJunction());
				for (MOVE move1 : MOVE.values()) {
					if (junctionNode.neighbourhood.containsKey(move1)) {
						if (!explored.get(junctionNode.neighbourhood.get(move1))) {
							Node nextNode = maze.graph[junctionNode.neighbourhood.get(move1)];
							Node lastNode = junctionNode;
							// public Camino(Integer id, Junction startJunction)
							Camino actCamino = new Camino(CaminoIdentifier.getInstance().newCamino(), startJunction);
							Integer place = 1;
							while (nextNode.numNeighbouringNodes <= 2) {
								if (nextNode.pillIndex != -1)
									actCamino.addPill();
								if (nextNode.powerPillIndex != -1)
									actCamino.addPowerPill(place);
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
								place++;
							}
							explored.set(lastNode.nodeIndex, true);
							waitList.add(nextNode);
							caminos.add(actCamino);
						}
					}
				}
			}
		}
	}
	
	private void extra {
		maze.
		
		
		
		
		// donde se guardan los caminos?
		private final List<Camino> maze;
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
		// TODO Falta de implementar.
		return null;
	}
	
	/* Se deben almacenar la lista de transiciones con el fin de eliminar las líneas temporales
	 * alternativas que no han sucedido */
	public List<Map<Agente, Action>> inferTransitions(final State state) {
		// TODO Falta de implementar.
		return null;
	}
}
