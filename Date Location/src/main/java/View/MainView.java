package View;

import Controller.GraphBuilder;
import Controller.GraphTraverser;
import Util.Utils;

import java.util.Scanner;

public class MainView {
    final private boolean hasStarted;

    final private GraphBuilder graphBuilder;
    final private GraphTraverser graphTraverser;
    final private DFSView dfsView;
    final private Utils utils;

    final private Scanner inputScanner;

    public MainView(GraphBuilder graphBuilder, GraphTraverser graphTraverser, DFSView dfsView, Scanner inputScanner, Utils utils) {
        hasStarted = false;
        this.graphBuilder = graphBuilder;
        this.graphTraverser = graphTraverser;
        this.dfsView = dfsView;
        this.inputScanner = inputScanner;
        this.utils = utils;
    }

    private void inputGraph() {
        utils.clearScreen();
        int nodeCount, edgeCount;
        System.out.println("Enter number of graph nodes followed by edge count:");
        nodeCount = inputScanner.nextInt();
        edgeCount = inputScanner.nextInt();

        System.out.println("\nEnter node labels separated by space:");
        for (var i = 0; i < nodeCount; i++) {
            var newNodeLabel = inputScanner.nextInt();
            graphBuilder.addNewNode(newNodeLabel);
        }

        System.out.println("""
                                
                Enter edges in the following format:
                -  head, tail, weight of the edge""");
        for (var i = 0; i < edgeCount; i++) {
            var headLabel = inputScanner.nextInt();
            var tailLabel = inputScanner.nextInt();
            var edgeWeight = inputScanner.nextInt();
            graphBuilder.addNewBidirectionalEdge(headLabel, tailLabel, edgeWeight);
        }
    }

    public void showMainMenu() {
        if (!hasStarted)
            inputGraph();
        utils.clearScreen();
        System.out.println("""
                Please choose an option:
                1) Run DFS algorithm
                """);

        var option = inputScanner.nextInt();
        switch (option) {
            case 1:
                dfsView.showDFSMenu();
                break;
            default:
                showMainMenu();
        }
    }
}
