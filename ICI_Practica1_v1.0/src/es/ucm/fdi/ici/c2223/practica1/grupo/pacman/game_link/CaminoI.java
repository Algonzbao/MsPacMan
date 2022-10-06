package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Camino;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.CaminoIdentifier;

public interface CaminoI {
	
	static CaminoI createCamino() {
		return new Camino(CaminoIdentifier.getInstance().newCamino(), startJunction);
	}
}
