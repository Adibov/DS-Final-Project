package model.graph;

public class Edge {
    final private Node head, tail;
    final private int weight;

    public Edge(Node head, Node tail, int weight) {
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getWeight() {
        return weight;
    }
}
