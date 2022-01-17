package model.algorithms.dijkstra;

import model.graph.Graph;
import model.graph.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraExecutor {
    final private Graph graph;
    final private NodeDistanceComparator nodeDistanceComparator;
    final private PriorityQueue<NodeDistancePair> minHeap;
    final private Map<Node, Integer> nodeDistances;

    public DijkstraExecutor(Graph graph, NodeDistanceComparator nodeDistanceComparator) {
        this.graph = graph;
        this.nodeDistanceComparator = nodeDistanceComparator;
        this.minHeap = new PriorityQueue<>(nodeDistanceComparator);
        this.nodeDistances = new HashMap<>();
    }

    public HashMap<Node, Integer> getNodeDistances(Node startingNode) {
        minHeap.clear();
        nodeDistances.clear();

        for (var node : graph.getNodeList())
            nodeDistances.put(node, Integer.MAX_VALUE);
        nodeDistances.put(startingNode, 0);
        minHeap.add(new NodeDistancePair(startingNode, 0));

        while (!minHeap.isEmpty()) {
            var minPair = minHeap.poll();
            if (nodeDistances.get(minPair.getNode()) < minPair.getDistance())
                continue;

            for (var adjacentEdge : minPair.getNode().getAdjacentEdges()) {
                var tail = adjacentEdge.getTail();
                var weight = adjacentEdge.getWeight();
                var newDistance = minPair.getDistance() + weight;
                if (newDistance < nodeDistances.get(tail)) {
                    minHeap.add(new NodeDistancePair(tail, newDistance));
                    nodeDistances.put(tail, newDistance);
                }
            }
        }
        return new HashMap<>(nodeDistances);
    }
}
