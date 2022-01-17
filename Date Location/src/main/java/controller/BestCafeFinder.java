package controller;

import model.algorithms.BestCafeExecutor;
import model.graph.BestCafeGraph;
import model.graph.Node;

import java.util.ArrayList;

public class BestCafeFinder {
    final private BestCafeExecutor bestCafeExecutor;
    final private BestCafeGraph bestCafeGraph;
    private boolean hasInitialized;

    public BestCafeFinder(BestCafeExecutor bestCafeExecutor, BestCafeGraph bestCafeGraph) {
        this.bestCafeExecutor = bestCafeExecutor;
        this.bestCafeGraph = bestCafeGraph;
        this.hasInitialized = false;
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

    public ArrayList<Node> getBestCafePlacesOptimized() {
        if (!hasInitialized) {
            bestCafeExecutor.initializeNodeDistances();
            hasInitialized = true;
        }
        return bestCafeExecutor.getBestCafePlacesOptimised();
    }

    public Node[] getCandidates() {
        return bestCafeGraph.getCandidateNodes();
    }

    public Node[] getNonCandidates() {
        return bestCafeGraph.getNonCandidateNodes();
    }
}
