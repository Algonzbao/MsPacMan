package es.ucm.fdi.ici.c2223.practica1.grupo.pacman.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conmutador {

	private static void conmutador() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 10; k++)
					for (int l = 0; l < 10; l++)
						System.out.println(i * 1000 + j * 100 + k * 10 + l);
	}

	private static void conmutador(final List<Integer> limit, final int pos, final List<Integer> action) {
		final int LIMIT = limit.get(pos);
		for (int i = 0; i < LIMIT; i++) {
			action.set(pos, i);
			if (limit.size() == pos + 1)
				tratarAction(action);
			else
				conmutador(limit, pos + 1, action);
		}
	}
	
	private static void tratarAction(List<Integer> action) {
		Integer outInt = 0;
		for (Integer i : action) {
			outInt *= 10;
			outInt += i;
		}
		String out = String.format("%" + action.size() + "s", outInt).replace(' ', '0');
		System.out.println(out);
	}
	
	public static void main(String[] args) {
		conmutador();
		
		List<Integer> limit = new ArrayList<>(List.of(5, 2, 4, 6));
		conmutador(limit, 0, new ArrayList<> (Collections.nCopies (limit.size(), null)));
	}
}
