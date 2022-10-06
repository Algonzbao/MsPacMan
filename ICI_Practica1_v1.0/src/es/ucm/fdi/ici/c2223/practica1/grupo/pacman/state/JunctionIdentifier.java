package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

public class JunctionIdentifier {

	private static JunctionIdentifier junIden;
	private Integer numJunctions;
	
	static JunctionIdentifier getInstance() {
		if (junIden == null)
			junIden = new JunctionIdentifier();
		return junIden;
	}
	
	private JunctionIdentifier() {
		this.numJunctions = 0;
	}
	
	public Integer newJunction() {
		return this.numJunctions++;
	}
	public Integer getNumCaminos() {
		return this.numJunctions;
	}
}
