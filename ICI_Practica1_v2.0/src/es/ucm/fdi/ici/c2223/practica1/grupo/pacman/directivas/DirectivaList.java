package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.directivas;

public class DirectivaList {

	private static Directiva[] directivas = {
		new EliminarPacman(),
		new EvitarPacman(),
		new EvitarFantasma(), // Mayor prioridad que Eliminar Fantasma
		new EliminarFantasma(),
		new IrPuntoMedioConPacman(),
		new IrPowerPillProxima()
	};
	
	public static Directiva[] getDirectivas() {
		return directivas;
	}
}
