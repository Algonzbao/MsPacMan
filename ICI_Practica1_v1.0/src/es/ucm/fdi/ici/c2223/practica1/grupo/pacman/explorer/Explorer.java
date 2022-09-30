package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.HashMap;
import java.util.Map;

public class Explorer {

	
	
	private class ArbolExploracion {
		private ArbolExploracion left;
		private ArbolExploracion center;
		private ArbolExploracion right;
		
	}
	
	private Map<Camino, Boolean> camMap;
	private Integer exploredCaminos;
	
	Explorer() {
		this.exploredCaminos = 0;
		camMap = new HashMap<Camino, Boolean>();
	}
	
	void explorar(Camino cam) {
		for (Camino c : cam.nextCaminos()) {
			if (isExplored(cam))
				explorar(c);
		}
	}
	
	/*
	private boolean isAllExplored() {
		return State.getInstance().getNumCaminos() == exploredCaminos;
	}
	*/
	
	private boolean isExplored(Camino cam) {
		if (camMap.)
	}
}
