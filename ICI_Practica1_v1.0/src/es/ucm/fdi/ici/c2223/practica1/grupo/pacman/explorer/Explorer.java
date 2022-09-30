package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer;

import java.util.HashMap;
import java.util.Map;

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
	
	private Map<Integer, Boolean> camMap;
	
	Explorer() {
		camMap = new HashMap<Integer, Boolean>();
	}
	
	ArbolExploracion explorar(Camino cam) {
		ArbolExploracion ae = new ArbolExploracion(cam);
		ArbolExploracion act;
		Integer count = 0;
		for (Camino ca : cam.nextCaminos()) {
			count++;
			if (!isExplored(ca)) {
				camMap.put(cam.getIdCamino(), true);
				act = explorar(ca);
				switch (count) {
				case 1 :
					ae.setLeft(act);
					break;
				case 2 :
					ae.setCenter(act);
					break;
				default :
					ae.setRight(act);
				}
			}
		}
		return ae;
	}
	
	/*
	private boolean isAllExplored() {
		return State.getInstance().getNumCaminos() == exploredCaminos;
	}
	*/
	
	private boolean isExplored(Camino cam) {
		return camMap.containsKey(cam.getIdCamino());
	}
}
