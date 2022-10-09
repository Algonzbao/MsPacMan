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
}
