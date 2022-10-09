package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import pacman.game.Constants.MOVE;

public class Calculator {

	// 1. Fantasma distancia minima con Pacman
	// 2. No se corte el camino de un fantasma con el de otro
	
	// 2.5 Si el fastams llega antes, que vaya
	// 3. Calcular radio de influencia de PowerPill para que huya el fantasma o si esta fuera evita entrar
	// 4. Si un fastamas es devil que huya
	
	public static MOVE getNextMove(Agente agente) {
		
		for (MOVE m : GameContainer.getPossibleMoves())) {
			
		}
	}
	private Integer calculatePoints(State state, Maze maze) {
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
