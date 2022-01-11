package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    final private Map<Integer, Node> labelMap;
    final private List<Node> nodeList;

    public Graph() {
        labelMap = new HashMap<>();
        nodeList = new ArrayList<>();
    }

    public void addNewNode(Node node) {
        if (labelMap.containsValue(node))
            throw new RuntimeException("This node already exists in this graph.");
        labelMap.put(node.getNodeLabel(), node);
        nodeList.add(node);
    }

    public Node getNodeByLabel(int v) {
        if (!labelMap.containsKey(v))
            throw new RuntimeException("No node with this label found.");
        return labelMap.get(v);
    }

    public List<Node> getNodeList() {
        return nodeList;
    }
}
