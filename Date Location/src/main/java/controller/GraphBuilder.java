package controller;

import model.graph.BestCafeGraph;
import model.graph.Edge;
import model.graph.Node;

import java.util.ArrayList;

public class GraphBuilder {
    final private BestCafeGraph bestCafeGraph;

    public GraphBuilder(BestCafeGraph bestCafeGraph) {
        this.bestCafeGraph = bestCafeGraph;
    }

    public void addNewNode(int v) {
        var newNode = new Node(v);
        bestCafeGraph.addNewNode(newNode);
    }

    public void addNewDirectedEdge(int head, int tail, int weight) {
        var nodeV = bestCafeGraph.getGraph().getNodeByLabel(head);
        var nodeU = bestCafeGraph.getGraph().getNodeByLabel(tail);
        var newEdge = new Edge(nodeV, nodeU, weight);
        nodeV.addAdjacentEdge(newEdge);
    }

    public void addNewBidirectionalEdge(int head, int tail, int weight) {
        addNewDirectedEdge(head, tail, weight);
        addNewDirectedEdge(tail, head, weight);
    }

    public ArrayList<Integer> getGraphNodeLabels() {
        ArrayList<Integer> labelsList = new ArrayList<>();
        for (var node : bestCafeGraph.getGraph().getNodeList())
           labelsList.add(node.getNodeLabel());
        return labelsList;
    }

    public boolean hasNodeLabel(int nodeLabel) {
        return bestCafeGraph.getGraph().hasNodeLabel(nodeLabel);
    }
}
