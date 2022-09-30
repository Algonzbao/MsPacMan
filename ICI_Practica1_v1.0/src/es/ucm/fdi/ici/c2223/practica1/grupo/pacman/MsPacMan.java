package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import java.util.List;
import java.util.Map;

import pacman.controllers.PacmanController;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.game.internal.Ghost;
import pacman.game.internal.Maze;

public final class MsPacMan extends PacmanController {

	private static final Integer TEAM_ID = 1;
	private static final Integer TIME_LIMIT = 40;
	
	private enum Player {
		PACKMAN, G1, G2, G3, G4;
	}
	
	private class Esclavo {
		
		private volatile boolean continuar;
		private volatile MOVE respuesta;
		private class Node {
			Boolean isAlpha;
			List<Node> sons;
			Integer addScore;
			Map<Player, MOVE> moves;
		}
		
		private Node node;
		
		private class Tree {
			private Node firstNode;
		}
		
		private void nextNode(int idNode, int score) {
			List<Rama> ramas = Memory.getNextRama(idNode);
			int max = 0;
			Rama mejor = null;
			for (Rama r : ramas) {
				int points = r.getPoints();
				if (points > max) {
					mejor = r;
					max = points;
				}
			}
		}
		
		private void calcular(Game game) {
			Maze maze = game.getCurrentMaze();
			// Si un fantasma ha tomado una decision, anotarla
			//Funciona nuestro github?
			
			final int numLayer = 10;
			int maxScore = 0;
			while (continuar) {
				for (int i = 0; i < numLayer; i++) {
					
				}
			}
			// Avanzar en el arbol de decisiones
			
			
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
			*/
			
			//sea Recorrido.ghost("G1"), una List<MOVE> con los movimeitnos de G1 a PA;
			//----- Primera aproxiamcion -----------------------------------------------
			//--------------------------------------------------------------------------
			for (Ghost g : GhostList) {
				ArbolRecorrido ar = ArbolRecorrido(g);
				// Recorrido r = Recorrido.ghost("G1").calcular();
				Recorrido r = new Recorrido(g1.getNode(), pa.getNode());
				ar.add(r);
				// Move m1 = r.last().invert();
				Node n1 ) r.lastNode();
				// for (Move m2 : pa.getNode().getNextMove()) {
				for (Node n2 : pa.getNode().getPossibleNextNodes()) {
					if (n1 != m2) {
						Recorrido r1 = new Recorrdio(g1.getNode(), pa.getNode());
						ar.add(r1);
					}
				}
			}
			List<MOVE> recorrido;
			//----------------------------------------------------------------------------------
			// -------Segunda aproximacion-------------------------------------------------------
			for (Camino c : caminos) {
				calcularRecorridoMinimo(g1.getCamino(), c);
				calcularRecorridoMinimo(g2.getCamino(), c);
				calcularRecorridoMinimo(g3.getCamino(), c);
				calcularRecorridoMinimo(g4.getCamino(), c);
				calcularRecorridoMinimo(pa.getCamino(), c);
			}
			// recPac es recorridoPacman o caminosPacman
			// c.futureNode() === c.nextNode().nextNode()
			for (Camino c : recPac) {
				// El tiempo no es un isntante sino un intervalo, el igual mira si se solapan.
				if (c.getTime("pacman") == c.invert().getTime("anyghost")) {
					c.setTerminal();
				}
				if (c.lastNode().getTimeDecision() < c.nextNode().getTimeDecision()) {
					c.lastNode().delCam(c, c.lastNode().getTimeDecision());
				} else if (c.lastNode().getTimeDecision() > c.nextNode().getTimeDecision()){
					c.nextNode().delCam(c, c.nextNode().getTimeDecision());
					for (Camino c1 : c.nextNode().getUnexploredCams()) {
						calcularRecorridoMinimo(c1, c.lastNode());
					}
					if (c.nextNode().allDelCam(c.nextNode.getTimeDecision())) {
						if (c.pastNode().getTimeDecision() > c.futureNode().getTimeDecision())
							c.futureNode().delCam(c.futureCamino(), c.futureNode().getTime())
					}
				} else {}
			}
		}
		private MOVE getRespuesta() {
			return respuesta;
		}
	}
	
	public MsPacMan() {
		super();
		setName("MsPacMan" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public MOVE getMove(Game game, long timeDue) {
		long inicio = System.currentTimeMillis();
		Esclavo esclavo = new Esclavo();
		new Thread(new Runnable() {
			@Override
			public void run() {
				esclavo.calcular(game);
			}
		}).start();
		try {
			Thread.sleep(TIME_LIMIT * 1000);
		} catch (InterruptedException e) {
			System.err.println("Se ha lanzado una excepci�n de interrupci�n");
		}
		MOVE respuesta = esclavo.getRespuesta();
		long fin = System.currentTimeMillis();
		double tiempo = (double) ((fin - inicio) / 1000);
		System.out.println("Tiempo de inicio: " + inicio);
		System.out.println("Tiempo de fin: " + fin);
		System.out.println("Duraci�n: " + tiempo +" segundos");
		return respuesta;
	}
	
}

