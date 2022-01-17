package model.algorithms.dijkstra;

import java.util.Comparator;

public class NodeDistanceComparator implements Comparator<NodeDistancePair> {
    @Override
    public int compare(NodeDistancePair o1, NodeDistancePair o2) {
        return o1.getDistance() - o2.getDistance();
    }
}
