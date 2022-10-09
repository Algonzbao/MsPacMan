package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import pacman.game.Constants.MOVE;

public class ArbolAlphaBeta {
	
	private final State raiz;
	private final Boolean isLeaf;
	private final Boolean isPacmanPlay;
	private final Boolean isGhostPlay;
	private final Integer ownPoints;
	private Integer maxPoints;
	private final Transition lastMoves;
	private Transition bestNextMoves;
	private final ArbolAlphaBeta father;
	private Map<Transition, ArbolAlphaBeta> sons;
	
	private Integer easyAdvanceTimer;
	
	public ArbolAlphaBeta(State raiz, Boolean isLeaf, Boolean isPacmanPlay, Boolean isGhostPlay,
			Integer ownPoints, Transition lastMoves, ArbolAlphaBeta father, Integer easyAdvanceTimer) {
		this.raiz = raiz;
		this.isLeaf = isLeaf;
		this.isPacmanPlay = isPacmanPlay;
		this.isGhostPlay = isGhostPlay;
		this.ownPoints = ownPoints;
		this.lastMoves = lastMoves;
		this.father = father;
		this.maxPoints = 0;
		this.easyAdvanceTimer = easyAdvanceTimer;
	}
	
	public State getState() {
		return raiz;
	}
	public Boolean isLeaf() {
		return isLeaf;
	}
	public Boolean isPacmanPlay() {
		return isPacmanPlay;
	}
	public Boolean isGhostPlay() {
		return isGhostPlay;
	}
	public Integer getPoints() {
		return ownPoints + maxPoints;
	}
	public Transition getBestNextMoves() {
		return bestNextMoves;
	}
	public List<ArbolAlphaBeta> getSons() {
		List<ArbolAlphaBeta> list = new ArrayList<>();
		for (Entry<Transition, ArbolAlphaBeta> e : sons.entrySet())
			list.add(e.getValue());
		return list;
	}
	// Precondición: Si no hay ningún movimiento, transition será un set de entradas (Agente, MOVE.NEUTRAL).
	// Precondición: La transition siempre estará mapeada.
	public ArbolAlphaBeta getSon(Transition transition) {
		for (Transition t : sons.keySet()) {
			if (t.equals(transition))
				return sons.get(t);
		}
		return null;
	}
	public void addSon(Transition transition, ArbolAlphaBeta aab) {
		sons.put(transition, aab);
		improveMaxPoints(transition, aab.getPoints());
	}
	protected void improveMaxPoints(Transition moves, Integer sonPoints) {
		if (sonPoints > this.maxPoints) {
			this.bestNextMoves = moves;
			if (this.father != null)
				this.father.improveMaxPoints(this.lastMoves, getPoints());
		}
	}
	public MOVE getBestMove(Agente agente) {
		return bestNextMoves.getMove(agente);
	}
	public boolean tryEasyAdvance() {
		if (easyAdvanceTimer > 0) {
			easyAdvanceTimer--;
			return true;
		}
		return false;
	}
}