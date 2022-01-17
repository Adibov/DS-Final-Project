package model.algorithms.dijkstra;

import model.graph.Node;

import java.util.Objects;

public class NodeDistancePair {
    final private Node node;
    final private int distance;

    public NodeDistancePair(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeDistancePair)) return false;
        NodeDistancePair that = (NodeDistancePair) o;
        return distance == that.distance && Objects.equals(node, that.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, distance);
    }
}
