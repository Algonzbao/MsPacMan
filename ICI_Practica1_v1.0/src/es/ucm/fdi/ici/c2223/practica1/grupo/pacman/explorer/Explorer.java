package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.HashMap;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Camino;

public class Explorer {

	public class ArbolExploracion {
		
		private Camino raiz;
		private ArbolExploracion left;
		private ArbolExploracion center;
		private ArbolExploracion right;
		
		private ArbolExploracion(Camino raiz) {
			this.raiz = raiz;
		}
		private void setLeft(ArbolExploracion ae) {
			this.left = ae;
		}
		private void setCenter(ArbolExploracion ae) {
			this.center = ae;
		}
		private void setRight(ArbolExploracion ae) {
			this.right = ae;
		}
		public Camino getRaiz() {
			return raiz;
		}
		public ArbolExploracion getLeft() {
			return left;
		}
		public ArbolExploracion getCenter() {
			return center;
		}
		public ArbolExploracion getRight() {
			return right;
		}
	}
	
	private Map<Integer, Boolean> exploredPaths;
	
	public Explorer() {
		this.exploredPaths = new HashMap<Integer, Boolean>();
	}
	
	// Esto es un recorrido en profundidad, ¡no en anchura!.
	public ArbolExploracion explorar(Camino camino) {
		ArbolExploracion ae = new ArbolExploracion(camino);
		Integer count = 0;
		for (Camino c : camino.getNextCaminos()) {
			count++;
			if (!isExplored(c)) {
				exploredPaths.put(camino.getId(), true);
				ArbolExploracion son = explorar(c);
				switch (count) {
				case 1 :
					ae.setLeft(son);
					break;
				case 2 :
					ae.setCenter(son);
					break;
				default :
					ae.setRight(son);
				}
			}
		}
		return ae;
	}
	
	/* ALTERNATIVE IMPLEMENTATION
	 * Esto es un recorrido en profundidad, ¡no en anchura!.
	public ArbolExploracion explorar(Camino camino) {
		ArbolExploracion ae = new ArbolExploracion(camino);
		for (Camino c : camino.getNextCaminos()) {
			if (!isExplored(c)) {
				ArbolExploracion son = explorar(c);
				ae.addSon(son);
			}
		}
		return ae;
	} */
	
	private boolean isExplored(Camino camino) {
		return this.exploredPaths.containsKey(camino.getId());
	}
}
