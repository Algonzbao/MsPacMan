package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions;

import es.ucm.fdi.ici.Input;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.MyInput;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures.Node;
import es.ucm.fdi.ici.fsm.Transition;
import pacman.game.Constants.GHOST;

public class IsPacmanGonnaDie implements Transition {

	// Maybe use "evaluate(in)" for advanced search?
	@Override
	public boolean evaluate(Input in) {
		if (isGonnaDieInHisActualWay((MyInput) in))
			return true;
		for (MyInput myin : ((MyInput) in).nextStages()) {
			if (!this.isGonnaDieInHisActualWay((MyInput) myin))
				return false;
		}
		return true;
	}
	
	private Boolean isGonnaDieInHisActualWay(MyInput in) {
		Node powerPillInTheWay = in.getPPByWay(in.getPacmanWay());
		// Means if a power pills exists in the way
		if (powerPillInTheWay == null) {
			Double pacmanToPPDistance = in.getDistancePacmanToNode(powerPillInTheWay);
			for (GHOST ghost : GHOST.values()) {
				Double ghostToPPDistance = in.getDistanceGhostToNode(ghost, powerPillInTheWay);
				if (ghostToPPDistance <= pacmanToPPDistance)
					return true;
			}
		} else {
			Node pacmanNextJunction = in.getPacmanNextJuction();
			Integer pacmanToNextJunctionDistance = in.getPacmanDistanceToNextJuction();
			for (GHOST ghost : GHOST.values()) {
				Double ghDistance = in.getDistanceGhostToNode(ghost, pacmanNextJunction);
					if (ghDistance <= pacmanToNextJunctionDistance)
						return true;
			}
		}
		return false;
	}
}
