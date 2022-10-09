package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Maze;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Position;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;

public class StateMachine {
	
	
	
	'caminos' bien puede ser un recorrido o bien un árbol de exploración para Pacman
	c.futureNode() === c.nextNode().nextNode()
	c.getPacmanTime() === Es el tiempo en el que Pacman llegaría al camino si fuese por el camino más corto
	
	for (Camino c : caminos) {
		// El tiempo no es un instante sino un intervalo, se debe mirar si se solapan.
		if (c.getPacmanTime() == c.invert().getAnyghostTime()) {
			c.setTerminal();
		}
		if (c.lastNode().getTimeDecision() < c.nextNode().getTimeDecision()) {
			c.lastNode().delCam(c, c.lastNode().getTimeDecision());
		} else if (c.lastNode().getTimeDecision() > c.nextNode().getTimeDecision()){
			c.nextNode().delCam(c, c.nextNode().getTimeDecision());
			for (Camino c1 : c.nextNode().getUnexploredCams())
				calcularRecorridoMinimo(c1, c.lastNode());
			if (c.nextNode().allDelCam(c.nextNode.getTimeDecision())) {
				if (c.pastNode().getTimeDecision() > c.futureNode().getTimeDecision())
					c.futureNode().delCam(c.futureCamino(), c.futureNode().getTime())
			}
		} else {...}
	}
	*/
	
	public Integer calculatePoints(State state, Maze maze) {
		Position pacPos = state.getPosition(Agente.PACMAN);
		List<Position> ghosts = new ArrayList<>();
		for (Agente a : Agente.values())
			if (a != Agente.PACMAN)
				ghosts.add(state.getPosition(a));
		for (Position ghPos : ghosts) {
			if (pacPos.getCamino() == ghPos.getCamino().invert())
				return Integer.MIN_VALUE;
		}
		
		Integer pacToNodeDistance = pacPos.getCamino().getDistance() - pacPos.getPlace();
		Integer pacEndNode = pacPos.getCamino().getEndNode();
		for (Position ghPos : ghosts) {
			Integer ghostToNodeDistance = ghPos.getCamino().getDistance() - ghPos.getPlace();
			Integer ghEndNode = ghPos.getCamino().getEndNode();
			if (ghostToNodeDistance + maze.getDistance(ghEndNode, pacEndNode) <= pacToNodeDistance)
				return Integer.MIN_VALUE;
		}
		return pacPos.getCamino().getPoints();
	}
}