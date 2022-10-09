package es.ucm.fdi.ici.c2223.practica1.grupo;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.Ghosts;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.MsPacMan;
import pacman.Executor;
import pacman.controllers.GhostController;
import pacman.controllers.PacmanController;

public class ExecutorTest {

	public static void main(String[] args) {
		Executor executor = new Executor.Builder()
				.setTickLimit(4000)
				.setVisual(true)
				.setScaleFactor(2.0)
				.build();
		PacmanController pacMan = new MsPacMan();
		GhostController ghosts = new Ghosts();
		System.out.println(
			executor.runGame(pacMan, ghosts, 30)
		);
	}
}
