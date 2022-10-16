package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives;

public class GhostDirectiveList {
	
	private static GhostDirective[] directivas = {
		// new EliminarSeguroPacman(),
		new EvitarPacman(),
		// new IrPuntoMedioConPacman(),
		// new PerseguirPacman()
	};
	
	public static GhostDirective[] getDirectivas() {
		return directivas;
	}
}
