package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.List;

public class Camino {

	private Integer startNode;
	private Integer endNode;
	private Integer id;
	private Integer distance;
	private List<Camino> nextCaminos;
	private Camino invert;
	
	Camino(Integer id, Integer distance, Integer startNode, Integer endNode) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.id = id;
		this.distance = distance;
		this.nextCaminos = new ArrayList<>();
	}
	
	public Integer getId() {
		return this.id;
	}
	public Integer getDistance() {
		return this.distance;
	}
	void addCamino(Camino c) {
		nextCaminos.add(c);
	}
	public List<Camino> getNextCaminos() {
		return nextCaminos;
	}
	public Integer getNumNextCaminos() {
		return nextCaminos.size();
	}
	public Camino invert() {
		return this.invert;
	}
	public void setInvert(Camino invert) {
		this.invert = invert;
	}
	public Integer getStartNode() {
		return startNode;
	}
	public Integer getEndNode() {
		return endNode;
	}

	public Integer getPoints() {
		return null;
	}
}
