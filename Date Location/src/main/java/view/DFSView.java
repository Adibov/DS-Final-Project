package view;

import controller.GraphBuilder;
import controller.GraphTraverser;
import model.graph.Node;
import util.Utils;

import java.util.List;
import java.util.Scanner;

public class DFSView {
    private Utils utils;
    private GraphBuilder graphBuilder;
    private GraphTraverser graphTraverser;

    public DFSView(Utils utils, GraphBuilder graphBuilder, GraphTraverser graphTraverser) {
        this.utils = utils;
        this.graphBuilder = graphBuilder;
        this.graphTraverser = graphTraverser;
    }

    private void showNodeLabels(List<Node> nodeList) {
        utils.clearScreen();
        System.out.println("Result sequence:");
        for (var node : nodeList)
            System.out.print(node.getNodeLabel() + " ");
        System.out.println();
        utils.getInput();
    }

    public void showDFSMenu() {
        utils.clearScreen();
        System.out.println("Choose a starting node:");
        for (var nodeLabel : graphBuilder.getGraphNodeLabels())
            System.out.print(nodeLabel + " ");
        System.out.println();

        int chosenLabel;
        boolean firstTime = false;
        do {
            if (firstTime)
                System.out.println("Invalid node label.");
            if (!firstTime)
                firstTime = true;
            chosenLabel = utils.nextInt();
        } while (!graphBuilder.hasNodeLabel(chosenLabel));

        showNodeLabels(graphTraverser.getDFSSequence(chosenLabel));
    }
}
