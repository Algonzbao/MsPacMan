package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.HashMap;
import java.util.Map;

public class EdgeMap {

	private Map<Integer, Map<Integer, Edge>> map;
	
	public EdgeMap() {
		this.map = new HashMap<>();
	}
	private EdgeMap(Map<Integer, Map<Integer, Edge>> map) {
		this.map = map;
	}
	public EdgeMap copy() {
		Map<Integer, Map<Integer, Edge>> newMap = new HashMap<>();
		for (Integer i : map.keySet()) {
			Map<Integer, Edge> iMap = new HashMap<>();
			for (Integer j : map.get(i).keySet())
				iMap.put(j, map.get(i).get(j).copy());
			newMap.put(i, iMap);
		}
		return new EdgeMap(newMap);
	}
	public void set(Integer id1, Integer id2, Edge edge) {
		if (id1 < id2) {
			if (!map.containsKey(id1))
				map.put(id1, new HashMap<>());
			map.get(id1).put(id2, edge);
		} else {
			if (!map.containsKey(id2))
				map.put(id2, new HashMap<>());
			map.get(id2).put(id1, edge);
		}
	}
	public Edge get(Integer id1, Integer id2) {
		if (id1 < id2)
			return map.get(id1).get(id2);
		return map.get(id2).get(id1);
	}
}