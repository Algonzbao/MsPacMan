package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

public class Position {

	private Camino camino;
	private Integer place;
	
	public Position(Camino camino, Integer place) {
		this.camino = camino;
		this.place = place;
	}
	
	public Camino getCamino() {
		return camino;
	}
	public Integer getPlace() {
		return place;
	}
	public boolean isInTheEnd() {
		return camino.getDistance() == place;
	}
	
	public void advance() {
		place++;
	}

	// Campo 'state' necesario para la herencia de Jail
	public Position copy(State state) {
		return new Position(this.camino, this.place);
	}
}