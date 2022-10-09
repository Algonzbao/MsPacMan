package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.constants.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.extra.Calculator;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives.PacmanDirective;
import pacman.game.Constants.GHOST;

public class GhostDirectiveList {
	
	private static GhostDirective[] directivas = {
		new EliminarSeguroPacman(),
		new EliminarPacman(),
		new EvitarPacman(),
		new IrPuntoMedioConPacman()
	};
		
	public static GhostDirective[] getDirectivas() {
		return directivas;
	}
}