package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.ArrayList;
import java.util.List;

public class PriorityAnalyzer {

	private volatile boolean continuar;
	private List<ArbolAlphaBeta> priorityQueue;
	
	public PriorityAnalyzer() {
		priorityQueue = new ArrayList<>();
	}
	
	public void stop() {
		continuar = false;
	}
	
	public void run() {
		continuar = true;
		while (continuar && !priorityQueue.isEmpty()) {
			ArbolAlphaBeta chosen = priorityQueue.get(0);
			new Turing(chosen);
			for (ArbolAlphaBeta son : chosen.getSons())
				priorizate(son);
		}
	}
	
	/* Necesitamos una mejor poda:
	- Aproximarse a PowerPills (para Pacman)
	- Cortar caminos a Pacman (para los Ghosts)
	- Posición cuántica de ghosts
	- Rutas entre PowerPills
	- Localización de ciclos
	- Equelibremos los hijos aún explorando más del más
	promotedor (escalera de exploración en el árbol).
	*/
	private void priorizate(ArbolAlphaBeta aab) {
		if (!aab.isLeaf())
			priorityQueue.add(aab);
	}
}
