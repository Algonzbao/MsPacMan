package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives.EvitarPacman;

public class GhostsDirectiveList {
	
	private static GroupDirective[] directives = {
		new EvitarPacmanG()
	};
	
	public static GroupDirective[] getDirectives() {
		return directives;
	}
}
