package model.algorithms;

import model.algorithms.dijkstra.DijkstraExecutor;
import model.graph.BestCafeGraph;
import model.graph.Node;

import java.util.ArrayList;

public class BestCafeExecutor {
    final private DijkstraExecutor dijkstraExecutor;
    final private BestCafeGraph bestCafeGraph;
    final private DFSExecutor dfsExecutor;

    public BestCafeExecutor(DijkstraExecutor dijkstraExecutor, BestCafeGraph bestCafeGraph, DFSExecutor dfsExecutor) {
        this.dijkstraExecutor = dijkstraExecutor;
        this.bestCafeGraph = bestCafeGraph;
        this.dfsExecutor = dfsExecutor;
    }

    public ArrayList<Node> getBestCafePlaces() {
        var bestCafes = new ArrayList<Node>();

        var minDistance = Integer.MAX_VALUE;
        for (var candidateCafe : dfsExecutor.getDFSSequence()) {
            var totalDistance = 0;
            var nodeDistances = dijkstraExecutor.getNodeDistances(candidateCafe);
            var candidateNodes = bestCafeGraph.getCandidateNodes();
            for (var i = 0; i < candidateNodes.length; i++)
                for (var j = i + 1; j < candidateNodes.length; j++)
                    totalDistance += Math.abs(nodeDistances.get(candidateNodes[i]) - nodeDistances.get(candidateNodes[j]));

            if (totalDistance < minDistance) {
                minDistance = totalDistance;
                bestCafes.clear();
                bestCafes.add(candidateCafe);
            }
            else if (totalDistance == minDistance)
                bestCafes.add(candidateCafe);
        }
        return bestCafes;
    }
}
