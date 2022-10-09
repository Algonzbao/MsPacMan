package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;

public class Jail extends Position {

	private State state;
	private Integer remainJailTime;
	private Agente agente;
	
	public Jail(State state, Integer jailTime, Agente agente) {
		super(null, null);
		this.remainJailTime = jailTime;
		this.agente = agente;
		this.state = state;
	}
	@Override
	public boolean isInTheEnd() {
		return false;
	}
	@Override
	public void advance() {
		remainJailTime--;
		if (remainJailTime == 0) {
			state.unjail(agente);
		}
	}
	@Override
	public Position copy(State state) {
		return new Jail(state, this.remainJailTime, this.agente);
	}
	@Override
	public Integer remainToEnd() {
		Position ghostInitialPosition = Labyrinth.get().createGhostInitialPosition();
		return remainJailTime + ghostInitialPosition.remainToEnd();
	}
}