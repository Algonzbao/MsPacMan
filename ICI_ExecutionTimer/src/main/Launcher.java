package main;

public class Launcher {
	
	public static void main(String[] args) {
		Maestro maestro = new Maestro();
		long inicio = System.currentTimeMillis();
		maestro.trabaja(5);
		long fin = System.currentTimeMillis();
		double tiempo = (double) ((fin - inicio) / 1000);
		System.out.println("Tiempo de inicio: " + inicio);
		System.out.println("Tiempo de fin: " + fin);
		System.out.println("Duración: " + tiempo +" segundos");
	}
}
