package main;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maze {

	private List<Camino> caminos;
	private List<List<Integer>> path;
	private Integer numNodes;
	private static final Integer[][] ady = {
		{2, 3, 4},
		{2, 3, 5},
		{2, 3, 5}
		
	};
	
	
	public Maze() {
		caminos = new ArrayList<>();
	}
	
	private Integer id;
	private Integer distance;
	private List<Camino> nextCaminos;
	private Camino invert;
	
	public void addCamino(Integer distance) {
		Integer id = CaminoIdentifier.getInstance().newCamino();
		Camino c = new Camino(id, distance);
		caminos.add(c);
	}
	public void addInvertPath() {
		for (Camino c : caminos) {
			c.se
		}
	}
	public Integer getDistance(Integer node1, Integer node2) {
		return path.get(node1).get(node2);
	}
	
	public void initAdy() {
		int numNodes = caminos.size();
		List<List<Integer>> ady = new ArrayList<>();
		List<Integer> list = Collections.nCopies(numNodes, null);
		ady.add(list);
		for (int i = 1; i < numNodes; i++)
			ady.add(List.copyOf(list));
	}
	
	/* Se trata del algoritmo de Floyd-Warshall, que halla la distancia entre todo par de nodos en O(n^3).
	 * Me he basado en la explicación e implementación en C++ de 'https://www.ecured.cu/Floyd-Warshall'.
	 */
	public void floyd(final List<List<Integer>> ady) {
		path = List.copyOf(ady);
		for (int i = 0; i < numNodes; i++)
			path.get(i).set(i, 0);
		for (int i = 0; i < numNodes; i++)
			for (int j = 0; j < numNodes; j++)
				for (int k = 0; k < numNodes; k++) {
					int distance = path.get(j).get(i) + path.get(i).get(k);
					if (distance < path.get(j).get(k))
						path.get(j).set(k, distance);
				}
	}
}
