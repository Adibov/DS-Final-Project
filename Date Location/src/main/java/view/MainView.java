package view;

import controller.GraphBuilder;
import util.Utils;

import java.util.Scanner;

public class MainView {
    private boolean hasStarted;

    final private GraphBuilder graphBuilder;
    final private DFSView dfsView;
    final private BestCafeView bestCafeView;
    final private Utils utils;

    public MainView(GraphBuilder graphBuilder, DFSView dfsView, BestCafeView bestCafeView, Utils utils) {
        hasStarted = false;
        this.graphBuilder = graphBuilder;
        this.dfsView = dfsView;
        this.bestCafeView = bestCafeView;
        this.utils = utils;
    }

    private void inputGraph() {
        utils.clearScreen();
        int nodeCount, edgeCount;
        System.out.println("Enter number of graph nodes followed by edge count:");
        var inputBuffer = utils.nextInt(2);
        nodeCount = inputBuffer[0];
        edgeCount = inputBuffer[1];

        System.out.println("\nEnter node labels separated by space:");
        for (var nodeLabel : utils.nextInt(nodeCount))
            graphBuilder.addNewNode(nodeLabel);

        System.out.println("""
                                
                Enter edges in the following format:
                -  head, tail, weight of the edge""");
        for (var i = 0; i < edgeCount; i++) {
            inputBuffer = utils.nextInt(3);
            var headLabel = inputBuffer[0];
            var tailLabel = inputBuffer[1];
            var edgeWeight = inputBuffer[2];
            graphBuilder.addNewBidirectionalEdge(headLabel, tailLabel, edgeWeight);
        }
        this.hasStarted = true;
    }

    public void showMainMenu() {
        if (!hasStarted)
            inputGraph();
        utils.clearScreen();
        System.out.println("""
                Choose an option:
                1) Run DFS algorithm (phase 0)
                2) Start finding the best cafe (phase 1)
                3) Exit""");

        var option = utils.nextInt();
        switch (option) {
            case 1:
                dfsView.showDFSMenu();
                break;
            case 2:
                bestCafeView.showBestCafeMenu();
                break;
            case 3:
                utils.clearScreen();
                System.out.println("Hope to see you again :)");
                return;
            default:
                System.out.println("Invalid input");
                utils.getInput();
        }
        showMainMenu();
    }
}
