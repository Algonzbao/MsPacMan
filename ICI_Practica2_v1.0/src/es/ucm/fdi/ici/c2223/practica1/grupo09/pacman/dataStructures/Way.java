package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures;

import java.util.List;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.exceptions.NodeIsNotInWayException;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.exceptions.NodesAreNotConsecutiveException;

public class Way {

	private Junction startJunction;
	private Junction endJunction;
	private List<Node> nodes;
	private Integer powerPillPosition;
	
	public Junction getStartJunction() {
		return this.startJunction;
	}
	public Junction getEndJunction() {
		return this.endJunction;
	}
	/***
	 * Less efficient implementation
	 * @throws NodeIsNotInWayException 
	 */
	/*
	Distance distanceBetweenNodes(Node node1, Node node2) throws NoNodesInWayException, NodesNoConsecutiveException {
		Integer node1Position = null;
		Integer node2Position = null;
		Integer index = 0;
		for (Node n : nodes) {
			if (n == node1) {
				node1Position = index + 1;
			}
			if (n == node2) {
				node2Position = index + 1;
			}
			index++;
		}
		if (node1 == this.startJunction)
			node1Position = 0;
		if (node2 == this.endJunction)
			node2Position = nodes.size() + 1;
		if (node1Position == null || node2Position == null)
			throw new NoNodesInWayException();
		if (node1Position > node2Position)
			throw new NodesNoConsecutiveException();
		return new Distance(node2Position - node1Position);
	}*/
	
	private Integer getNodePosition(Node node) throws NodeIsNotInWayException {
		Integer nodePosition = null;
		if (node == this.startJunction)
			nodePosition = 0;
		else if (node == this.endJunction)
			nodePosition = nodes.size() + 1;
		else {
			Integer index = 0;
			for (Node n : nodes) {
				if (n == node) {
					nodePosition = index + 1;
					break;
				}
				index++;
			}
			if (nodePosition == null)
				throw new NodeIsNotInWayException();
		}
		return nodePosition;
	}
	
	Integer distanceBetweenNodes(Node node1, Node node2) throws NodeIsNotInWayException, NodesAreNotConsecutiveException {
		Integer node1Position = getNodePosition(node1);
		Integer node2Position = getNodePosition(node2);
		if (node1Position > node2Position)
			throw new NodesAreNotConsecutiveException();
		return node2Position - node1Position;
	}
	Integer distanceNodeToEnd(Node node) throws NodeIsNotInWayException {
		Integer nodePosition = getNodePosition(node);
		Integer endJunctionPosition = nodes.size() + 1;
		return endJunctionPosition - nodePosition;
	}
	public Node getEndNode() {
		return this.endJunction;
	}
	public Node getPowerPillNode() {
		return nodes.get(this.powerPillPosition);
	}
}
