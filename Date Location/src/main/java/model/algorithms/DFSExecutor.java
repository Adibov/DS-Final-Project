package model.algorithms;

import model.graph.Graph;
import model.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSExecutor {
    final private Graph graph;
    final private Map<Node, Boolean> markedNodes;
    final private List<Node> nodeSequence;

    public DFSExecutor(Graph graph) {
        this.graph = graph;
        markedNodes = new HashMap<>();
        nodeSequence = new ArrayList<>();
    }

    private void initializeFields() {
        nodeSequence.clear();
        markedNodes.clear();
    }


    private void dfs(Node currentNode) {
        markedNodes.put(currentNode, true);
        for (var adjacentEdge : currentNode.getAdjacentEdges()) {
            var adjacentNode = adjacentEdge.getTail();
            if (!markedNodes.containsKey(adjacentNode))
                dfs(adjacentNode);
        }
        nodeSequence.add(currentNode);
    }

    public ArrayList<Node> getDFSSequence() {
        initializeFields();
        for (var node : graph.getNodeList())
            if (!markedNodes.containsKey(node))
                dfs(node);
        return new ArrayList<>(nodeSequence);
    }

    public ArrayList<Node> getDFSSequence(int startingNodeLabel) {
        initializeFields();
        var startingNode = graph.getNodeByLabel(startingNodeLabel);
        dfs(startingNode);
        return new ArrayList<>(nodeSequence);
    }
}
