import controller.BestCafeFinder;
import controller.GraphBuilder;
import controller.GraphTraverser;
import model.algorithms.BestCafeExecutor;
import model.algorithms.DFSExecutor;
import model.algorithms.dijkstra.DijkstraExecutor;
import model.algorithms.dijkstra.NodeDistanceComparator;
import model.graph.BestCafeGraph;
import model.graph.Graph;
import util.Utils;
import view.BestCafeView;
import view.DFSView;
import view.MainView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        BestCafeGraph bestCafeGraph = new BestCafeGraph(graph);
        GraphBuilder graphBuilder = new GraphBuilder(bestCafeGraph);
        DFSExecutor dfsExecutor = new DFSExecutor(graph);
        NodeDistanceComparator nodeDistanceComparator = new NodeDistanceComparator();
        DijkstraExecutor dijkstraExecutor = new DijkstraExecutor(graph, nodeDistanceComparator);
        GraphTraverser graphTraverser = new GraphTraverser(dfsExecutor);
        BestCafeExecutor bestCafeExecutor = new BestCafeExecutor(dijkstraExecutor, bestCafeGraph, dfsExecutor);
        BestCafeFinder bestCafeFinder = new BestCafeFinder(bestCafeExecutor, bestCafeGraph);
        Scanner inputScanner = new Scanner(System.in);
        Utils utils = new Utils(inputScanner);
        DFSView dfsView = new DFSView(utils, graphBuilder, graphTraverser);
        BestCafeView bestCafeView = new BestCafeView(bestCafeFinder, utils);
        MainView mainView = new MainView(graphBuilder, dfsView, bestCafeView, utils);
        mainView.showMainMenu();
//        graphBuilder.addNewNode(10);
//        graphBuilder.addNewNode(7);
//        graphBuilder.addNewNode(19);
//        graphBuilder.addNewNode(20);
//        graphBuilder.addNewNode(1);
//        graphBuilder.addNewBidirectionalEdge(10, 7, 50);
//        graphBuilder.addNewBidirectionalEdge(19, 7, 20);
//        graphBuilder.addNewBidirectionalEdge(7, 20, 1);
//        graphBuilder.addNewBidirectionalEdge(1, 20, 5);


    }
}

/*
10 7 19 20 1

7 10 50
7 20 1
20 1 5
7 19 20
 */
