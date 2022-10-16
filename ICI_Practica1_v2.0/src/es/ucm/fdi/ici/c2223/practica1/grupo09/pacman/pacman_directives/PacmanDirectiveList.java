package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.pacman_directives;

public class PacmanDirectiveList {
	
	private static PacmanDirective[] directivas = {
		// new EvitarFantasma(),
		new EliminarFantasma(),
		new IrPowerPillProxima()
	};
	
	public static PacmanDirective[] getDirectivas() {
		return directivas;
	}
}
