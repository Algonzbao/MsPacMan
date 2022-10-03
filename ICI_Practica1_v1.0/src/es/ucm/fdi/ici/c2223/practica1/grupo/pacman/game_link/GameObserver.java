package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Action;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.Camino;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state.State;
import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.internal.Maze;

public class GameObserver {

	private final Game game;
	
	public GameObserver(final Game game) {
		this.game = game;
	}
	
	public State getActualState() {
		Maze maze = game.getCurrentMaze();
		// donde se guardan los caminos?
		private final List<Camino> maze;
		public void getPills(Game game, Camino camino) {
			int[] data = game.getActivePillsIndices();
			for(int i = 0; i < game.getActivePillsIndices().length; i++) {
				pillPos.put(camino, data[i]);
			}
		}
		public void getPowerPills(Game game, Camino camino) {
			int[] data = game.getActivePowerPillsIndices();
			for(int i = 0; i < game.getActivePowerPillsIndices().length; i++) {
				powerPillPos.setFirst(camino);
				powerPillPos.setSecond(data[i]);
			}
		}
		public void getPMPosition(Game game) {
			pacmanPos = game.getPacmanCurrentNodeIndex();
		}
		
		public void getGhostsPosition(Game game) {
			ArrayList<Integer> eachGhostPos = new ArrayList<>();
			for (GHOST ghostType : GHOST.values()) {
				eachGhostPos.add(game.getGhostCurrentNodeIndex(ghostType));
			}
		}
		// TODO Falta de implementar.
		return null;
	}
	
	/* Se deben almacenar la lista de transiciones con el fin de eliminar las líneas temporales
	 * alternativas que no han sucedido */
	public List<Map<Agente, Action>> inferTransitions(final State state) {
		// TODO Falta de implementar.
		return null;
	}
}
