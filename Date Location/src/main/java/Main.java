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

        HashFunction hashFunction = new HashFunction();
        HashTable<Integer, Integer> hashTable = new HashTable<>(hashFunction);
//        while (true) {
//            int t = inputScanner.nextInt();
//            if (t == 1) {
//                int key = inputScanner.nextInt();
//                int value = inputScanner.nextInt();
//                hashTable.put(key, value);
//            }
//            else if (t == 2) {
//                int key = inputScanner.nextInt();
//                System.out.println(hashTable.get(key));
//            }
//            else if (t == 3) {
//                int key = inputScanner.nextInt();
//                hashTable.remove(key);
//            }
//            System.out.println(hashTable);
//        }

    }
}

/*
10 7 19 20 1

7 10 50
7 20 1
20 1 5
7 19 20
 */
