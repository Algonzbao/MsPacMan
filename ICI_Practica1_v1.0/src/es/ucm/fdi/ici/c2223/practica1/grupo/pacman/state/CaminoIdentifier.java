package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

public class CaminoIdentifier {

	private static CaminoIdentifier camIden;
	private Integer numCaminos;
	
	static CaminoIdentifier getInstance() {
		if (camIden == null)
			camIden = new CaminoIdentifier();
		return camIden;
	}
	
	CaminoIdentifier() {
		this.numCaminos = 0;
	}
	
	Integer newCamino() {
		return this.numCaminos++;
	}
	Integer getNumCaminos() {
		return this.numCaminos;
	}
}
