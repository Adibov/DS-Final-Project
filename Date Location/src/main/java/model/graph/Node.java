package model.graph;

import model.map.HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    final private int nodeLabel;
    final private List<Edge> adjacentEdges;
    private HashTable<Node, Integer> nodeDistances;

    public Node(int nodeLabel) {
        this.nodeLabel = nodeLabel;
        this.adjacentEdges = new ArrayList<>();
    }

    public void addAdjacentEdge(Edge edge) {
        if (edge.getHead().getNodeLabel() != nodeLabel)
            throw new RuntimeException("Head of the given edge does not equal to this node.");
        adjacentEdges.add(edge);
    }

    public int getNodeLabel() {
        return nodeLabel;
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public HashTable<Node, Integer> getNodeDistances() {
        return nodeDistances;
    }

    public void setNodeDistances(HashTable<Node, Integer> nodeDistances) {
        this.nodeDistances = nodeDistances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return nodeLabel == node.nodeLabel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeLabel);
    }
}
