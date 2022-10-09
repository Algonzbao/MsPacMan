package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.directivas;

public class DirectivaList {

	private static Directiva[] directivas = {
		new EliminarFantasma(),
		new EliminarPacman(),
		new EvitarPacman(),
		new EvitarFantasma(),
		new IrPuntoMedioConPacman(),
		new IrPowerPillProxima()
	};
	
	public static Directiva[] getDirectivas() {
		return directivas;
	}
}
