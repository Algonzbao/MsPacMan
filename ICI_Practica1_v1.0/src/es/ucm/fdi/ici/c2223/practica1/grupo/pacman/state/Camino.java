package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.List;

public class Camino {

	private Integer id;
	private Integer distance;
	private List<Camino> nextCaminos;
	
	Camino(Integer id, Integer distance) {
		this.id = id;
		this.distance = distance;
		this.nextCaminos = new ArrayList<>();
	}
	
	public Integer getId() {
		return this.id;
	}
	Integer getDistance() {
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
}
