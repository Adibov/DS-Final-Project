import controller.BestCafeFinder;
import controller.GraphBuilder;
import controller.GraphTraverser;
import model.algorithms.BestCafeExecutor;
import model.algorithms.DFSExecutor;
import model.algorithms.dijkstra.DijkstraExecutor;
import model.algorithms.dijkstra.NodeDistanceComparator;
import model.graph.BestCafeGraph;
import model.graph.Graph;
import model.map.HashFunction;
import model.map.HashTable;
import util.Utils;
import view.BestCafeOptimisedView;
import view.BestCafeView;
import view.DFSView;
import view.MainView;

import java.util.Scanner;

public class Main {
    static private MainView mainView;

    public static void main(String[] args) {
        injectDependencies();
        mainView.showMainMenu();
    }

    private static void injectDependencies() {
        Graph graph = new Graph();
        HashFunction hashFunction = new HashFunction();
        BestCafeGraph bestCafeGraph = new BestCafeGraph(graph);
        GraphBuilder graphBuilder = new GraphBuilder(bestCafeGraph);
        DFSExecutor dfsExecutor = new DFSExecutor(graph);
        NodeDistanceComparator nodeDistanceComparator = new NodeDistanceComparator();
        DijkstraExecutor dijkstraExecutor = new DijkstraExecutor(graph, nodeDistanceComparator);
        GraphTraverser graphTraverser = new GraphTraverser(dfsExecutor);
        BestCafeExecutor bestCafeExecutor = new BestCafeExecutor(dijkstraExecutor, bestCafeGraph, dfsExecutor, hashFunction);
        BestCafeFinder bestCafeFinder = new BestCafeFinder(bestCafeExecutor, bestCafeGraph);
        Scanner inputScanner = new Scanner(System.in);
        Utils utils = new Utils(inputScanner);
        DFSView dfsView = new DFSView(utils, graphBuilder, graphTraverser);
        BestCafeView bestCafeView = new BestCafeView(bestCafeFinder, utils);
        BestCafeOptimisedView bestCafeOptimisedView = new BestCafeOptimisedView(bestCafeFinder, utils);
        mainView = new MainView(graphBuilder, dfsView, bestCafeView, bestCafeOptimisedView, utils);

    }
}

/*
5 4
10 7 19 20 1
7 10 50
7 20 1
20 1 5
7 19 20

6 9
0 1 2 3 4 5
0 2 4
0 4 1
0 5 6
1 4 2
1 5 1
2 3 2
2 4 3
4 5 9
3 5 4
 */
