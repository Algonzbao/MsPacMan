package main;

public class Maestro {

	private Esclavo esclavo;
	
	Maestro() {
		esclavo = new Esclavo();
	}
	
	public void trabaja(Integer tiempo) {
		System.out.println(Thread.currentThread().toString());
		Thread escTh = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().toString());
				esclavo.contar();
			}
		});
		escTh.start();
		try {
			Thread.sleep(tiempo * 1000);
		} catch (InterruptedException e) {
			System.err.println("Se ha lanzado una excepción de interrupción");
		}
		esclavo.detente();
		Integer contador = esclavo.getContador();
		System.out.println("El esclavo a trabajado hasta Contador = " + contador);
	}
}
