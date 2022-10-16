package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.ucm.fdi.ici.Input;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures.GameTransition;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures.Ghost;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures.Node;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures.Pacman;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures.Way;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class MyInput extends Input {

	private Pacman pacman;
	private Map<GHOST, Ghost> ghosts;
	
	public MyInput(Game game) {
		super(game);
	}

	@Override
	public void parseInput() {
		// TODO Auto-generated method stub
	}
	
	public Integer getPacmanDistanceToNextJuction() {
		return pacman.getDistanceToNextJuction();
	}
	
	public Node getPacmanNextJuction() {
		return pacman.getNextJuction();
	}

	public Way getPacmanWay() {
		return pacman.getWay();
	}

	public Node getPPByWay(Way way) {
		return way.getPowerPillNode();
	}
	
	
	public Double getDistancePacmanToNode(Node node) {
		Node pacmanNode = pacman.getNode();
		MOVE pacmanLastMove = pacman.getLastMove();
		return getDistanceBetweenNodes(pacmanNode, node, pacmanLastMove);
	}
	
	private Double getDistanceBetweenNodes(Node node1, Node node2, MOVE lastMove) {
		return this.game.getDistance(node1.getId(), node2.getId(), lastMove, DM.PATH);
	}

	public Double getDistanceGhostToNode(GHOST ghost, Node node) {
		Node ghostNode = ghosts.get(ghost).getNode();
		MOVE ghostLastMove = ghosts.get(ghost).getLastMove();
		return getDistanceBetweenNodes(ghostNode, node, ghostLastMove);
	}
	
	public List<MyInput> nextStages() {
		List<MyInput> nextStages = new ArrayList<>();
		List<GameTransition> transitions = generateTransitions();
		for (GameTransition t : transitions) {
			MyInput myInput = this.copy();
			myInput.transitate(t);
			nextStages.add(myInput);
		}
		return nextStages;
	}
	
	private List<GameTransition> generateTransitions() {
		List<GameTransition> transitions = new ArrayList<>();
		Integer time = pacman.getDistanceToNextJuction() + 1;
		Set<MOVE> moves = pacman.getNextJuction().getMoves();
		for (MOVE m : moves) {
			transitions.add(new GameTransition(time, m));
		}
		return transitions;
	}
	private MyInput copy() {
		Game game = this.game.copy();
		return new MyInput(game);
	}
	
	// TODO Falta calcular el nuevo MyInput
	private void transitate(GameTransition t) {
		MOVE m = t.getPacmanMove();
		for (int i = 0; i < t.getTime(); i++)
			this.advance();
		advance(m);
	}
	private void advance() {
		// TODO ..
	}
	private void advance(MOVE pacmanMove) {
		// TODO ..
	}
}
