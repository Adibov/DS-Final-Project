package Controller;

import Model.DFSExecutor;
import Model.Node;

import java.util.ArrayList;

public class GraphTraverser {
    final private DFSExecutor dfsExecutor;

    public GraphTraverser(DFSExecutor dfsExecutor) {
        this.dfsExecutor = dfsExecutor;
    }

    public ArrayList<Node> getDFSSequence(int startingNodeLabel) {
        return dfsExecutor.getDFSSequence(startingNodeLabel);
    }
}
