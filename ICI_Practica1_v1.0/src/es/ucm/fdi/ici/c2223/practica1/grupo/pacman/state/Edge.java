package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.state;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.ici.c2223.practica1.grupo.pacman.util.Pair;

public class Edge {
	
	private Integer powerPillPlace;
	private Integer numPills;
	// Formato : Representación{1 6 # 9 11 # 13 13 # 14 16} == Contenido{[1,6],[9,11],13,[14,16}]
	private List<Pair<Integer, Integer>> pillIntervals;
	
	public Edge() {
		this.powerPillPlace = 0;
		this.numPills = 0;
		this.pillIntervals = new ArrayList<>();
	}
	public Edge(Integer powerPillPlace, Integer numPills, List<Pair<Integer, Integer>> pillIntervals) {
		this.powerPillPlace = powerPillPlace;
		this.numPills = numPills;
		this.pillIntervals = new ArrayList<>();
	}
	public void addPrice(Integer place, Price price) {
		if (price == Price.POWER_PILL) {
			this.powerPillPlace = place;
		} else if (numPills == 0)
			pillIntervals.add(new Pair<>(place, place));
		else {
			Pair<Integer, Integer> pair;
			for (int i = 0; i < pillIntervals.size(); i++) {
				pair = this.pillIntervals.get(i);
				if (place == pair.getSecond() + 1) {
					if (i == pillIntervals.size() - 1)
						pair.setSecond(place);
					else if (place == pillIntervals.get(i + 1).getFirst() - 1) {
						pillIntervals.get(i + 1).setFirst(pair.getFirst());
						pillIntervals.remove(i);
					}
					else
						pair.setSecond(place);
				}
				else if (place == pair.getFirst() - 1)
					pair.setFirst(place);
				else if (place < pair.getFirst()) {
					pillIntervals.add(i, new Pair<>(place, place));
				}
			}
			this.numPills++;
		}
	}
	public Price getAndRemoveIfExistsPrice(Integer place) {
		if (place == this.powerPillPlace) {
			this.powerPillPlace = 0;
			return Price.POWER_PILL;
		}
		Pair<Integer, Integer> pair;
		for (int i = 0; i < this.pillIntervals.size(); i++) {
			pair = this.pillIntervals.get(i);
			if (place < pair.getFirst())
				return null;
			if (place <= pair.getSecond()) {
				Integer first = pair.getFirst();
				Integer second = pair.getSecond();
				if (first == second )
					this.pillIntervals.remove(pair);
				else if (place == first)
					pair.setFirst(first + 1);
				else if (place == second)
					pair.setSecond(second - 1);
				else {
					pair.setFirst(place + 1);
					pillIntervals.add(0, new Pair<Integer, Integer>(first, place - 1));
				}
				this.numPills--;
				return Price.PILL;
			}
		}
		return null;
	}
	public Edge copy() {
		return new Edge(powerPillPlace, numPills, pillIntervals);
	}
	public Integer getNumPills() {
		return numPills;
	}
	public Boolean hasPowerPill() {
		return powerPillPlace != 0;
	}
}