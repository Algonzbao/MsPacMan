package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.Map;
import java.util.Set;

import pacman.game.Constants.MOVE;

public class Transition {

	private Map<Agente, MOVE> map;
	
	public Transition(Map<Agente, MOVE> map) {
		this.map = map;
	}
	
	public void put(Agente a, MOVE move) {
		this.map.put(a, move);
	}
	public MOVE getMove(Agente a) {
		return this.map.get(a);
	}
	public Set<Agente> getAgentes() {
		return map.keySet();
	}
	private Boolean exists(Agente a) {
		return map.containsKey(a) && map.get(a) != MOVE.NEUTRAL;
	}
	public Boolean equals(Transition t) {
		for (Agente a : Agente.values()) {
			if (exists(a)) {
				if (map.get(a) != t.getMove(a))
					return false;
			} else if (t.exists(a)) {
				return false;
			}
		}
		return true;
	}
}
