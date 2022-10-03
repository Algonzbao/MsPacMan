package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.TimeObject;

public class Timer {

	private TimeObject timeObject;
	
	public Timer(TimeObject timeObject) {
		this.timeObject = timeObject;
	}
	
	public void start() {
		timeObject.activate();
		timeObject.stop();
	}
}
