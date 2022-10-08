package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.explorer.Agente;
import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.game_link.GameContainer;
import pacman.game.Constants.MOVE;
import pacman.game.Constants;

public class State {
	
	/* TODO Seguramente, pills y powerPills no son necesarias pues, los caminos deberían guardar las referencias
	a las que están en ellos. El problema a esto, es que deberíamos separar la parte dinámica de cada camino
	(si tiene pills, powerpills o no) de la estática (sus conexiones con otros caminos).*/
	
	// TODO Hay que asegurarse del valor de las constantes.
	private static final Integer JAIL_TIME = 20;
	private static final Integer WEAK_TIME = 20;
	
	// Los caminos guardan las referencia entre sí.
	private final Labyrinth labyrinth;
	// No se puede poner 'final' a 'agents' por referencias cruzadas entre State y Jail, la inicialización se hace en dos partes.
	private Map<Agente, Position> agents;
	private final List<Douposition> pills;
	private final List<Douposition> powerPills;
	private final Map<Agente, Integer> isWeak;
	private Map<Integer, Price> junctionPrices;
	private EdgeMap edgeMap;
	private boolean pacmanIsDead;
	private boolean hasPower;
	private Integer points;
	
	public State(Labyrinth labyrinth, List<Douposition> pills, List<Douposition> powerPills,
			Map<Agente, Integer> isWeak, Map<Integer, Price> junctionPrices) {
		this.labyrinth = labyrinth;
		this.pills = pills;
		this.powerPills = powerPills;
		if (isWeak == null)
			this.isWeak = isWeak;
		else {
			this.isWeak = new HashMap<>();
			for (Agente a : Agente.ghosts())
				this.isWeak.put(a, 0);
		}
		this.junctionPrices = junctionPrices;
		this.pacmanIsDead = false;
		this.points = 0;
		this.hasPower = false;
	}
	public void initAgents(Map<Agente, Position> agents) {
		this.agents = agents;
	}
	
	private State copy() {
		State state = new State(
			this.labyrinth,
			List.copyOf(this.pills),
			List.copyOf(this.powerPills),
			Map.copyOf(this.isWeak),
			Map.copyOf(this.junctionPrices)
		);
		Map<Agente, Position> newAgents = Map.copyOf(this.agents);
		for (Entry<Agente, Position> e : newAgents.entrySet())
			e.setValue(e.getValue().copy(state));
		state.initAgents(newAgents);
		return state;
	}
	
	public boolean isFinal() {
		return this.pacmanIsDead;
	}
	//--------------------------------- TODO <ALEX> -------------------------------------------
	public boolean hasPowerPill(Camino c) {
		//Atributo booleando de si tiene powerpill,
		boolean hasPower = false;
			if(c.getpPillPos() > 0) {
				this.hasPower = true;
		}
			return hasPower;
	}
	
	public Integer amountPills(Camino c) {
		//atributo de cuantas pills hay 
			this.points = c.getPills();
		return points;
	}
	
	public Integer whoWins(Camino c) {
		// saber quien llega antes a la pill
		//for all the agents ver si en el camino hay alguna ppill y si la hay ver cuánto tarda
		//si hay fantasma y pacman en el mismo camino entonces calcular cuál de los dos llega antesç
		Integer distancePacman = 0, distanceGhost = Integer.MAX_VALUE;
		  for (Map.Entry<Agente,Position> ag : agents.entrySet()) {
	             if(ag.getKey() == Agente.PACMAN) {
	            	if(hasPowerPill(ag.getValue().getCamino())) {
	            		distancePacman = GameContainer.get().getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos());
	            	}
	             }
	             else {
	            	 if(hasPowerPill(ag.getValue().getCamino())) {
		            		if(distanceGhost < GameContainer.get().getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos())) {
		            			distanceGhost = GameContainer.get().getManhattanDistance(ag.getValue().getPlace(), c.getpPillPos());
		            		}
	            	 }	
	            }
	            
		  }
		  //valor minimo, me come el fantasma valor maximo, me lo como
		  Integer result = distancePacman >= distanceGhost ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
         	return result;
	}
	//--------------------------------- TODO <\ALEX> -------------------------------------------
	public Position getPosition(Agente a) {
		return agents.get(a);
	}
	
	public State getNext(Map<Agente, MOVE> transition) {
		return this.copy().advance(transition);
	}
	public State advance(Map<Agente, MOVE> transition) {
		moveGhosts(transition);
		removeAgents();
		movePacman(transition.get(Agente.PACMAN));
		removeAgents();
		removePills();
		return this;
	}
	
	private void moveGhosts(Map<Agente, MOVE> transition) {
		for (Agente a : Agente.ghosts()) {
			if (!this.getPosition(a).isInTheEnd()) {
				Position position = this.getPosition(a);
				position.advance();
			} else {
				Camino camino = this.getPosition(a).getCamino().getNextCamino(transition.get(a));
				this.setPosition(a, new Position(camino, 1));
			}
		}
	}
	private void movePacman(MOVE move) {
		if (!this.getPosition(Agente.PACMAN).isInTheEnd()) {
			Position position = this.getPosition(Agente.PACMAN);
			position.advance();
		} else {
			Camino camino = this.getPosition(Agente.PACMAN).getCamino().getNextCamino(move);
			this.setPosition(Agente.PACMAN, new Position(camino, 1));
		}
	}
	private void removeAgents() {
		Position pacman = this.getPosition(Agente.PACMAN);
		for (Agente g : Agente.ghosts()) {
			if (this.getPosition(g) == pacman) {
				if (isWeak(g)) {
					this.injail(g);
					isWeak.put(g, 0);
					this.points += Constants.GHOST_EAT_SCORE;
				} else {
					pacmanIsDead = true;
					this.points -= Constants.AWARD_LIFE_LEFT;
				}
			}
		}
	}
	private boolean isWeak(Agente a) {
		return isWeak.get(a) > 0;
	}
	private void removePills() {
		if (!this.pacmanIsDead) {
			Position pacman = this.getPosition(Agente.PACMAN);
			Price price = null;
			if (pacman.isInTheEnd()) {
				Integer idJunction = pacman.getCamino().getEndJunction();
				if (this.junctionPrices.containsKey(idJunction)) {
					price = this.junctionPrices.get(idJunction);
					this.junctionPrices.remove(idJunction);
				}
			} else {
				Camino camino = pacman.getCamino();
				Edge edge = getEdge(camino);
				Integer place = pacman.getPlace();
				if (camino.isInvert())
					place = camino.getDistance() - place;
				price = edge.getAndRemoveIfExistsPrice(place);
			}
			if (price == Price.PILL) {
				this.points += Constants.PILL;
			} else if (price == Price.POWER_PILL) {
				this.points += Constants.POWER_PILL;
				for (Agente a : Agente.ghosts()) {
					if (!(getPosition(a) instanceof Jail))
						isWeak.put(a, WEAK_TIME);
				}
			}
		}
	}
	private Edge getEdge(Camino c) {
		return edgeMap.get(c.getStartJunction(), c.getEndJunction());
	}
	
	private void setPosition(Agente a, Position position) {
		if (agents.containsKey(a))
			agents.remove(a);
		agents.put(a, position);
	}
	
	private void injail(Agente a) {
		this.setPosition(a, new Jail(this, JAIL_TIME, a));
	}
	public void unjail(Agente a) {
		this.setPosition(a, labyrinth.createGhostInitialPosition());
	}
}