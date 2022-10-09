package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra.Position;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;

public class EliminarSeguroPacman extends GhostDirective {

	@Override
	public MOVE getMove() {
		GameContainer.get().get;
		Position pacPos = state.getPosition(Agente.PACMAN);
		List<Position> ghosts = new ArrayList<>();
		for (Agente a : Agente.values())
			if (a != Agente.PACMAN)
				ghosts.add(state.getPosition(a));
		for (Position ghPos : ghosts) {
			if (pacPos.getCamino() == ghPos.getCamino().invert())
				return Integer.MIN_VALUE;
		}
		isInTheWay()
	}
	public static Boolean isInTheWay(Integer fromIndex, Integer toIndex, Integer index, MOVE lastMove) {
		// lastNode FALTA
		GameContainer.get().getNextMoveAwayFromTarget(0, 0, null)
		if (GameContainer.get().isJunction(index))
			return false;
		Integer lastNode, actualNode, nextNode;
		for (int i = 0; i < 2; i++) {
			lastNode = index;
			actualNode = GameContainer.get().getNeighbouringNodes(index)[i];
			while (!GameContainer.get().isJunction(actualNode)) {
				nextNode = GameContainer.get().getNeighbouringNodes(actualNode)[0];
				if (nextNode == lastNode)
					nextNode = GameContainer.get().getNeighbouringNodes(actualNode)[1];
				lastNode = actualNode;
				actualNode = nextNode;
			}
			if (actualNode != fromIndex && actualNode != toIndex)
				return false;
		}
		return lastMove == GameContainer.get().getNextMoveAwayFromTarget(fromIndex, toIndex, DM.PATH);
	}
	
	public static Integer nextJunction(Integer index, MOVE lastMove) {
		if (GameContainer.get().isJunction(index))
			return index;
		Integer[] junctions = new Integer[2];
		Integer lastNode, actualNode, nextNode;
		for (int i = 0; i < 2; i++) {
			lastNode = index;
			actualNode = GameContainer.get().getNeighbouringNodes(index)[i];
			while (!GameContainer.get().isJunction(actualNode)) {
				nextNode = GameContainer.get().getNeighbouringNodes(actualNode)[0];
				if (nextNode == lastNode)
					nextNode = GameContainer.get().getNeighbouringNodes(actualNode)[1];
				lastNode = actualNode;
				actualNode = nextNode;
			}
			junctions[i] = actualNode;
		}
		if (lastMove == GameContainer.get().getNextMoveAwayFromTarget(junctions[0], junctions[1], DM.PATH))
			return junctions[0];
		return  junctions[1];
	}
}
