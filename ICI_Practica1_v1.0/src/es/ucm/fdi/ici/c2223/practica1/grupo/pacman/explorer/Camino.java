package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.ArrayList;
import java.util.List;

public class Camino {

	private Integer idCamino;
	private List<Camino> nextCaminos;
	
	Camino(Integer idCamino) {
		this.idCamino = idCamino;
		nextCaminos = new ArrayList<>();
	}
	
	Integer getIdCamino() {
		return this.idCamino;
	}
	void addCamino(Camino c) {
		nextCaminos.add(c);
	}
	List<Camino> nextCaminos() {
		return nextCaminos;
	}
}
