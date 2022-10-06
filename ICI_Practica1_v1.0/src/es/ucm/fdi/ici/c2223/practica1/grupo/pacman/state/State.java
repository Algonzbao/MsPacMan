package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;


import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import pacman.game.Game;

public class State {
	
	// TODO Seguramente, maze no es necesario, pues los caminos guardan las referencia entre s�.
	/* TODO Seguramente, pills y powerPills no son necesarias pues, los caminos deber�an guardar las referencias
	a las que est�n en ellos. El problema a esto, es que deber�amos separar la parte din�mica de cada camino
	(si tiene pills, powerpills o no) de la est�tica (sus conexiones con otros caminos).*/
	
	private final List<Camino> maze;
	private final Map<Agente, Position> agentes;
	private final List<Douposition> pills;
	private final List<Douposition> powerPills;
	private boolean hasPower;
	private Integer points;
	private Game game;
	
	public State(List<Camino> maze, Map<Agente, Position> agentes, List<Douposition> pills, List<Douposition> powerPills, Game game) {
		this.maze = maze;
		this.agentes = agentes;
		this.pills = pills;
		this.powerPills = powerPills;
		this.points = 0;
		this.hasPower = false;
		this.game = game;
		
	}
	
	public boolean hasPowerPill(Camino c) {
		//Atributo booleando de si tiene powerpill,
		boolean hasPower = false;
			if(c.getpPillPos() > 0) {
				this.hasPower = true;
		}
			return hasPower;
	}
	
	public Integer amountPills(Camino c) {
		//atributo de cuantas pills hay 
			this.points = c.getPills();
		return points;
	}
	
	public Integer whoWins(Camino c) {
		// saber quien llega antes a la pill
		//for all the agents ver si en el camino hay alguna ppill y si la hay ver cu�nto tarda
		//si hay fantasma y pacman en el mismo camino entonces calcular cu�l de los dos llega antes�
		Integer distancePacman = 0, distanceGhost = Integer.MAX_VALUE;
		  for (Map.Entry<Agente,Position> ag : agentes.entrySet()) {
	             if(ag.getKey() == Agente.PACMAN) {
	            	if(hasPowerPill(ag.getValue().getCamino())) {
	            		distancePacman = game.getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos());
	            	}
	             }
	             else {
	            	 if(hasPowerPill(ag.getValue().getCamino())) {
		            		if(distanceGhost < game.getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos())) {
		            			distanceGhost = game.getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos());
		            		}
	            	 }	
	            }
	            
		  }
		  //valor minimo, me come el fantasma valor maximo, me lo como
		  Integer result = distancePacman >= distanceGhost ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
         	return result;
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
