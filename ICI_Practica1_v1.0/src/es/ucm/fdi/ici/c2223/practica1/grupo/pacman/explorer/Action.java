package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

public enum Action {
	
	LEFT(0), UP(1), DOWN(2);
	
	private final Integer id;
	
	private Action(Integer id) {
		this.id = id;
	}
	
	public static Action id(Integer id) {
		for (Action a : Action.values())
			if (id == a.id)
				return a;
		return null;
	}
}