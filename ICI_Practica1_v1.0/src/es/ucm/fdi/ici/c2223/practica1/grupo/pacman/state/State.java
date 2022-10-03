package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;

public class State {
	
	// TODO Seguramente, maze no es necesario, pues los caminos guardan las referencia entre s�.
	/* TODO Seguramente, pills y powerPills no son necesarias pues, los caminos deber�an guardar las referencias
	a las que est�n en ellos. El problema a esto, es que deber�amos separar la parte din�mica de cada camino
	(si tiene pills, powerpills o no) de la est�tica (sus conexiones con otros caminos).*/
	
	private final List<Camino> maze;
	private final Map<Agente, Position> agentes;
	private final List<Douposition> pills;
	private final List<Douposition> powerPills;
	
	public State(List<Camino> maze, Map<Agente, Position> agentes, List<Douposition> pills, List<Douposition> powerPills) {
		this.maze = maze;
		this.agentes = agentes;
		this.pills = pills;
		this.powerPills = powerPills;
	}
	
	public List<Camino> getMaze() {
		return maze;
	}
	public Position getPosition(Agente a) {
		return agentes.get(a);
	}
	public List<Douposition> getPills() {
		return pills;
	}
	public List<Douposition> getPowerPills() {
		return powerPills;
	}
}
