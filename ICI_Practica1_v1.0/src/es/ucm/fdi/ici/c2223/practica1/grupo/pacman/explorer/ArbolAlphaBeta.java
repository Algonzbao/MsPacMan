package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;

public class ArbolAlphaBeta {
	
	private final State raiz;
	private final Boolean isLeaf;
	private final Boolean isPacmanPlay;
	private final Boolean isGhostPlay;
	private final Integer ownPoints;
	private Integer maxPoints;
	private final Map<Agente, Action> lastMoves;
	private Map<Agente, Action> bestNextMoves;
	private final ArbolAlphaBeta father;
	private Map<Map<Agente, Action>, ArbolAlphaBeta> sons;
	
	public ArbolAlphaBeta(State raiz, Boolean isLeaf, Boolean isPacmanPlay, Boolean isGhostPlay,
			Integer ownPoints, Map<Agente,Action> lastMoves, ArbolAlphaBeta father) {
		this.raiz = raiz;
		this.isLeaf = isLeaf;
		this.isPacmanPlay = isPacmanPlay;
		this.isGhostPlay = isGhostPlay;
		this.ownPoints = ownPoints;
		this.lastMoves = lastMoves;
		this.father = father;
		this.maxPoints = 0;
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
	public Map<Agente, Action> getBestNextMoves() {
		return bestNextMoves;
	}
	public List<ArbolAlphaBeta> getSons() {
		List<ArbolAlphaBeta> list = new ArrayList<>();
		for (Entry<Map<Agente, Action>, ArbolAlphaBeta> e : sons.entrySet())
			list.add(e.getValue());
		return list;
	}
	public ArbolAlphaBeta getSon(Map<Agente, Action> transition) {
		if (!sons.containsKey(transition))
			return null;
		return sons.get(transition);
	}
	
	public void addSon(Map<Agente, Action> moves, ArbolAlphaBeta aab) {
		sons.put(moves, aab);
		improveMaxPoints(moves, aab.getPoints());
	}
	protected void improveMaxPoints(Map<Agente,Action> moves, Integer sonPoints) {
		if (sonPoints > this.maxPoints) {
			this.bestNextMoves = moves;
			if (this.father != null)
				this.father.improveMaxPoints(this.lastMoves, getPoints());
		}
	}
}