package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

public class StateMachine {
	
	/* Hallar el corrido de distancia m�nima entre el nodo siguiente a cada fantasma y el nodo siguiente
	 * a pacman. Desplegar las opciones de cambio de ruta desde pacman, y ver el recorrido minimo desde los fantasma
	 * asociar a cada nodo un tiempo de pase (de pacman y cada fantasma) y anotar una lista para cada ciclo independiente
	 * un ciclo sera dependiente si es la conbinacion de varios ciclos.
	 * Una vez creado este arbol de deciciones deberemos ver las colisiones, es decir, cuando un fantasma y pacman estan
	 * al mismo tiempo en el mismo nodo; deberemos podar aquellas jugadas que permitan hacer a los fantasma algo cuando puedan
	 * cazar a pacman en otra opciones, y deberemos podar las acciones de pacman que le lleven a ser cazado.
	 * Despues deberemos incorporar un sistema de poda que integre los cambios por la toma de superpills por pacman
	 * (necesario saber cuanto tiempo dura el efecto de la superpill).
	 * Por ultimo, colocaremos el valor de sus bolitas a cada nodo y estudiaremos como forzar la poda de pacman de esas bolitas
	 * si jugamos con los fantasmas.
	
	 * Ser�a interesante dirigir los fantasmas, pero no a Pacman sino al nodo delante de Pacman. Ser�a intersante hacer que
	 * los recorridos de los fantasmas no se cruzaran con el fin de abarcar mas casillas. 
	
	-----------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------- APROXIMACI�N ----------------------------------------------------------
	/*
	'caminos' bien puede ser un recorrido o bien un �rbol de exploraci�n para Pacman
	c.futureNode() === c.nextNode().nextNode()
	c.getPacmanTime() === Es el tiempo en el que Pacman llegar�a al camino si fuese por el camino m�s corto
	
	for (Camino c : caminos) {
		// El tiempo no es un instante sino un intervalo, se debe mirar si se solapan.
		if (c.getPacmanTime() == c.invert().getAnyghostTime()) {
			c.setTerminal();
		}
		if (c.lastNode().getTimeDecision() < c.nextNode().getTimeDecision()) {
			c.lastNode().delCam(c, c.lastNode().getTimeDecision());
		} else if (c.lastNode().getTimeDecision() > c.nextNode().getTimeDecision()){
			c.nextNode().delCam(c, c.nextNode().getTimeDecision());
			for (Camino c1 : c.nextNode().getUnexploredCams())
				calcularRecorridoMinimo(c1, c.lastNode());
			if (c.nextNode().allDelCam(c.nextNode.getTimeDecision())) {
				if (c.pastNode().getTimeDecision() > c.futureNode().getTimeDecision())
					c.futureNode().delCam(c.futureCamino(), c.futureNode().getTime())
			}
		} else {...}
	}
	*/
}
