import Controller.GraphBuilder;
import Controller.GraphTraverser;
import Model.DFSExecutor;
import Model.Graph;
import Util.Utils;
import View.DFSView;
import View.MainView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphBuilder graphBuilder = new GraphBuilder(graph);
        DFSExecutor dfsExecutor = new DFSExecutor(graph);
        GraphTraverser graphTraverser = new GraphTraverser(dfsExecutor);
        Utils utils = new Utils();
        Scanner inputScanner = new Scanner(System.in);
        DFSView dfsView = new DFSView(utils, graphBuilder, graphTraverser, inputScanner);
        MainView mainView = new MainView(graphBuilder, graphTraverser, dfsView, inputScanner, utils);
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
