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
	- Posici�n cu�ntica de ghosts
	- Rutas entre PowerPills
	- Localizaci�n de ciclos
	- Equilibremos los hijos. A�n as� hay que explor m�s el �rbol
	promotedor (escalera de exploraci�n en el �rbol).
	*/
	private void priorizate(ArbolAlphaBeta aab) {
		if (!aab.isLeaf())
			priorityQueue.add(aab);
	}
}