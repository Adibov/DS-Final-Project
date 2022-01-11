package Controller;

import Model.Edge;
import Model.Graph;
import Model.Node;

import java.util.ArrayList;

public class GraphBuilder {
    final private Graph graph;

    public GraphBuilder(Graph graph) {
        this.graph = graph;
    }

    public void addNewNode(int v) {
        var newNode = new Node(v);
        graph.addNewNode(newNode);
    }

    public void addNewDirectedEdge(int head, int tail, int weight) {
        var nodeV = graph.getNodeByLabel(head);
        var nodeU = graph.getNodeByLabel(tail);
        var newEdge = new Edge(nodeV, nodeU, weight);
        nodeV.addAdjacentEdge(newEdge);
    }

    public void addNewBidirectionalEdge(int head, int tail, int weight) {
        addNewDirectedEdge(head, tail, weight);
        addNewDirectedEdge(tail, head, weight);
    }

    public ArrayList<Integer> getGraphNodeLabels() {
        ArrayList<Integer> labelsList = new ArrayList<>();
        for (var node : graph.getNodeList())
           labelsList.add(node.getNodeLabel());
        return labelsList;
    }

    public boolean hasNodeLabel(int nodeLabel) {
        return graph.hasNodeLabel(nodeLabel);
    }
}
