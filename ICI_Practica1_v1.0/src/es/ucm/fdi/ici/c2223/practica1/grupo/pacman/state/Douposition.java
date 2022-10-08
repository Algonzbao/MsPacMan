package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

public class Douposition {

	private Position position1;
	private Position position2;
	
	public Douposition(Position position1, Position position2) {
		this.position1 = position1;
		this.position2 = position2;
	}

	public Position getPosition1() {
		return position1;
	}
	public Position getPosition2() {
		return position2;
	}
}