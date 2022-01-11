package View;

import Controller.GraphBuilder;
import Controller.GraphTraverser;
import Model.Node;
import Util.Utils;

import java.util.List;
import java.util.Scanner;

public class DFSView {
    private Utils utils;
    private GraphBuilder graphBuilder;
    private GraphTraverser graphTraverser;

    private Scanner inputScanner;

    public DFSView(Utils utils, GraphBuilder graphBuilder, GraphTraverser graphTraverser, Scanner inputScanner) {
        this.utils = utils;
        this.graphBuilder = graphBuilder;
        this.graphTraverser = graphTraverser;
        this.inputScanner = inputScanner;
    }

    private void showNodeLabels(List<Node> nodeList) {
        utils.clearScreen();
        System.out.println("Result sequence:");
        for (var node : nodeList)
            System.out.print(node.getNodeLabel() + " ");
        System.out.println("\n\nEnter any key to continue...");
        inputScanner.nextLine();
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
            chosenLabel = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (!graphBuilder.hasNodeLabel(chosenLabel));

        showNodeLabels(graphTraverser.getDFSSequence(chosenLabel));
    }
}
