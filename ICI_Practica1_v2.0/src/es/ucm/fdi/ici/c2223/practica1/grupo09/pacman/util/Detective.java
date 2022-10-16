package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.util;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;

public class Detective {

	public static Boolean isInTheWay(Integer fromIndex, Integer toIndex, Integer index, MOVE lastMove) {
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
		// TODO Fallo de lógica pues no tiene porque ser así
		if (lastMove == GameContainer.get().getNextMoveAwayFromTarget(junctions[0], junctions[1], DM.PATH))
			return junctions[0];
		return junctions[1];
	}
}
