package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.extra;

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
	
	/* TODO Necesitamos podar para:
	- Aproximarse a PowerPills (para Pacman)
	- Cortar caminos a Pacman (para los Ghosts)
	- Posición cuántica de ghosts
	- Rutas entre PowerPills
	- Localización de ciclos
	- Equilibremos los hijos. Aún así hay que explor más el árbol
	promotedor (escalera de exploración en el árbol).
	*/
	private void priorizate(ArbolAlphaBeta aab) {
		if (!aab.isLeaf())
			priorityQueue.add(aab);
	}
}