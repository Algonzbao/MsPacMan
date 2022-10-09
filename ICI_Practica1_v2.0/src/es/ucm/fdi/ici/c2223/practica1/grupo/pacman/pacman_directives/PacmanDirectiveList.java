package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.pacman_directives;

public class PacmanDirectiveList {
	
	private static PacmanDirective[] directivas = {
		new EvitarFantasma(), // Mayor prioridad que Eliminar Fantasma
		new EliminarFantasma(),
		new IrPowerPillProxima()
	};
	
	public static PacmanDirective[] getDirectivas() {
		return directivas;
	}
}
