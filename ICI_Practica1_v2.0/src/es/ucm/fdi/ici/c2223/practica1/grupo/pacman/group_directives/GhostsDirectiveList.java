package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.group_directives;

public class GhostsDirectiveList {
	
	private static GroupDirective[] directives = {
		new EvitarPacmanG(),
		new IrPuntoMedioConPacmanG()
	};
	
	public static GroupDirective[] getDirectives() {
		return directives;
	}
}
