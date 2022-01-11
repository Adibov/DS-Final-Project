package Controller;

import Model.Edge;
import Model.Graph;
import Model.Node;

public class GraphBuilder {
    final private Graph graph;

    public GraphBuilder(Graph graph) {
        this.graph = graph;
    }

    public void addNewNode(int v) {
        var newNode = new Node(v);
        graph.addNewNode(newNode);
    }

    public void addNewEdge(int head, int tail, int weight) {
        var nodeV = graph.getNodeByLabel(head);
        var nodeU = graph.getNodeByLabel(tail);
        var newEdge = new Edge(nodeV, nodeU, weight);
        nodeV.addAdjacentEdge(newEdge);
    }
}
