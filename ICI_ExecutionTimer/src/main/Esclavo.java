package main;

public class Esclavo {

	private boolean switch01;
	private volatile Integer contador;
	private volatile boolean continuar;
	
	Esclavo() {
		contador = 0;
		continuar = false;
	}
	
	public void contar() {
		while (continuar) {
			for (int z = 0; z < contador; z++) {
				for (int j = 0; j < z; j++) {
					for (int i = 0; i < j; i++) {
						switch01 = !switch01;
					}
				}
			}
			contador++;
		}
	}
	public Integer getContador() {
		return contador;
	}
	public void detente() {
		continuar = false;
	}
}
