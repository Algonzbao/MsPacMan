package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.ghost_directives;

public class GhostDirectiveList {
	
	private static GhostDirective[] directivas = {
		new EliminarSeguroPacman(),
		// new EvitarPacman(),
		new IrPuntoMedioConPacman()
	};
	
	public static GhostDirective[] getDirectivas() {
		return directivas;
	}
}
