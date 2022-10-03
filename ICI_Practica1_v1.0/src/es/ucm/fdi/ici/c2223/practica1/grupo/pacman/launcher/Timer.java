package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.launcher;

public class Timer {

	private TimeObject timeObject;
	
	public Timer(TimeObject timeObject) {
		this.timeObject = timeObject;
	}
	
	public void start(final Long waitMillis) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				timeObject.run();
			}
		}).start();
		try {
			Thread.sleep(waitMillis);
		} catch (InterruptedException e) {
			System.err.println("La espera del timer ha sido interrumpida.");
		}
		timeObject.stop();
	}
}
