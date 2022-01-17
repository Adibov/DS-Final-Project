package model.graph;

import java.util.HashSet;
import java.util.Set;

public class BestCafeGraph {
    final private Graph graph;
    final private Set<Node> candidateNodes;
    final private Set<Node> nonCandidateNodes;

    public BestCafeGraph(Graph graph) {
        this.graph = graph;
        this.candidateNodes = new HashSet<>();
        this.nonCandidateNodes = new HashSet<>(graph.getNodeList());
    }

    public void addCandidate(Node node) {
        candidateNodes.add(node);
        nonCandidateNodes.remove(node);
    }

    public void removeCandidate(Node node) {
        candidateNodes.remove(node);
        nonCandidateNodes.add(node);
    }

    public Node[] getCandidateNodes() {
        var result = new Node[candidateNodes.size()];
        candidateNodes.toArray(result);
        return result;
    }

    public Node[] getNonCandidateNodes() {
        var result = new Node[nonCandidateNodes.size()];
        nonCandidateNodes.toArray(result);
        return result;
    }

    public void addNewNode(Node node) {
        graph.addNewNode(node);
        nonCandidateNodes.add(node);
    }

    public Graph getGraph() {
        return graph;
    }
}
