package controller;

import model.algorithms.BestCafeExecutor;
import model.graph.BestCafeGraph;
import model.graph.Node;

import java.util.ArrayList;

public class BestCafeFinder {
    final private BestCafeExecutor bestCafeExecutor;
    final private BestCafeGraph bestCafeGraph;

    public BestCafeFinder(BestCafeExecutor bestCafeExecutor, BestCafeGraph bestCafeGraph) {
        this.bestCafeExecutor = bestCafeExecutor;
        this.bestCafeGraph = bestCafeGraph;
    }

    public void addCandidate(Node node) {
        bestCafeGraph.addCandidate(node);
    }

    public void removeCandidate(Node node) {
        bestCafeGraph.removeCandidate(node);
    }

    public ArrayList<Node> getBestCafePlaces() {
        return bestCafeExecutor.getBestCafePlaces();
    }

    public Node[] getCandidates() {
        return bestCafeGraph.getCandidateNodes();
    }

    public Node[] getNonCandidates() {
        return bestCafeGraph.getNonCandidateNodes();
    }
}
