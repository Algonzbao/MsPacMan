package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.List;

public class Camino {

	private Integer startJunction;
	private Integer endJunction;
	private Integer id;
	private Integer distance;
	private Integer pills;
	private Integer pPillPos;
	private List<Camino> nextCaminos;
	private Camino invert;
	
	//numero de pills = distance
	//saber si tiene pPill = 0 no tiene 1 al principio y n la posicion en la que esta si es n+1 es posicion corrupta
	public Camino(Integer id, Integer distance, Integer pills, Integer pPillPos, Integer startJunction, Integer endJunction) {
		this.startJunction = startJunction;
		this.endJunction = endJunction;
		this.id = id;
		this.distance = distance;
		this.pills = pills;
		this.pPillPos = pPillPos;
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
	public Integer getPills() {
		return pills;
	}

	public void setPills(Integer pills) { //esto podemos usarlo para actualizar el numero de pills
		this.pills = pills;
	}

	public Integer getpPillPos() {
		return pPillPos;
	}

	public void setpPillPos(Integer pPillPos) {
		this.pPillPos = pPillPos;
	}
	public Camino invert() {
		return this.invert;
	}
	public void setInvert(Camino invert) {
		this.invert = invert;
	}
	public Integer getStartJunction() {
		return startJunction;
	}
	public Integer getEndJunction() {
		return endJunction;
	}
	public Integer getPoints() {
		return null;
	}
}
