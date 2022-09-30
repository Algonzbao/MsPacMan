package es.ucm.fdi.ici.c2223.practica1.grupo.pacman;

import java.util.List;

public class State {
	private Integer pacmanPos;
	private List<Integer> ghostPos;
	private List<Integer> PillPos;
	private List<Integer> PowerPillPos;
	private final List<Arista> map;
}
