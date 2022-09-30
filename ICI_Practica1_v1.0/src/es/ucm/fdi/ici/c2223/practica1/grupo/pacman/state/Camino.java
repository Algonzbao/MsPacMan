package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.List;

public class Camino {

	private Integer idCamino;
	private Integer distance;
	private List<Camino> nextCaminos;
	
	Camino(Integer idCamino, Integer distance) {
		this.idCamino = idCamino;
		this.distance = distance;
		this.nextCaminos = new ArrayList<>();
	}
	
	Integer getIdCamino() {
		return this.idCamino;
	}
	Integer getDistance() {
		return this.distance;
	}
	void addCamino(Camino c) {
		nextCaminos.add(c);
	}
	List<Camino> nextCaminos() {
		return nextCaminos;
	}
}
