package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.MOVE;
import pacman.game.Constants;

public class State {

	//--------------------------------- TODO <ALEX> -------------------------------------------
	
	public Integer whoWins(Camino c) {
		// saber quien llega antes a la pill
		//for all the agents ver si en el camino hay alguna ppill y si la hay ver cuánto tarda
		//si hay fantasma y pacman en el mismo camino entonces calcular cuál de los dos llega antesç
		Integer distancePacman = 0, distanceGhost = Integer.MAX_VALUE;
		  for (Map.Entry<Agente,Position> ag : agents.entrySet()) {
	             if(ag.getKey() == Agente.PACMAN) {
	            	if(hasPowerPill(ag.getValue().getCamino())) {
	            		distancePacman = GameContainer.get().getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos());
	            	}
	             }
	             else {
	            	 if(hasPowerPill(ag.getValue().getCamino())) {
		            		if(distanceGhost < GameContainer.get().getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos())) {
		            			distanceGhost = GameContainer.get().getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos());
		            		}
	            	 }	
	            }
	            
		  }
		  //valor minimo, me come el fantasma valor maximo, me lo como
		  Integer result = distancePacman >= distanceGhost ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
         	return result;
	}
	//--------------------------------- TODO <\ALEX> -------------------------------------------
	
}