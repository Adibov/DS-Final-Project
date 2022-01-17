package view;

import controller.BestCafeFinder;
import model.graph.Node;
import util.Utils;

import java.util.Scanner;

public class BestCafeView {
    final private BestCafeFinder bestCafeFinder;
    final private Utils utils;

    public BestCafeView(BestCafeFinder bestCafeFinder, Utils utils) {
        this.bestCafeFinder = bestCafeFinder;
        this.utils = utils;
    }

    private boolean showAvailableNodes(Node[] candidates) {
        if (candidates.length == 0) {
            System.out.println("No available node exist.");
            utils.getInput();
            return false;
        }

        System.out.println("Available nodes:");
        for (var node : candidates)
            System.out.print(node.getNodeLabel() + " ");
        System.out.println();
        return true;
    }

    private Node getNodeFromUser(Node[] candidates) {
        int selectedNodeLabel;
        Node selectedNode = null;
        var hasSelected = false;
        var isFirst = true;
        do {
            if (isFirst)
                isFirst = false;
            else
                System.out.println("Invalid node\n");
            System.out.print("Choose a node: ");
            selectedNodeLabel = utils.nextInt();

            for (var node : candidates)
                if (node.getNodeLabel() == selectedNodeLabel) {
                    selectedNode = node;
                    hasSelected = true;
                    break;
                }
        } while (!hasSelected);
        return selectedNode;
    }

    private void showAddCandidateMenu() {
        utils.clearScreen();
        var nonCandidates = bestCafeFinder.getNonCandidates();
        if (!showAvailableNodes(nonCandidates))
            return;

        var selectedNode = getNodeFromUser(nonCandidates);
        assert (selectedNode != null);
        bestCafeFinder.addCandidate(selectedNode);
        utils.clearScreen();
        System.out.println("Person joined successfully");
        utils.getInput();
    }

    private void showRemoveCandidateMenu() {
        utils.clearScreen();
        var candidates = bestCafeFinder.getCandidates();
        if (!showAvailableNodes(candidates))
            return;

        var selectedNode = getNodeFromUser(candidates);
        assert (selectedNode != null);
        bestCafeFinder.removeCandidate(selectedNode);
        utils.clearScreen();
        System.out.println("Person left successfully");
        utils.getInput();
    }

    private void showBestCafes() {
        var bestCafes = bestCafeFinder.getBestCafePlaces();
        System.out.println("Best cafes:");
        for (var node : bestCafes)
            System.out.print(node.getNodeLabel() + " ");
        System.out.println();
        utils.getInput();
    }

    public void showBestCafeMenu() {
        utils.clearScreen();
        System.out.println("""
                Choose an option:
                1) Add a new person to the set (join query)
                2) Remove a present person from the set (left query)
                3) Get best cafes
                4) Back to main menu""");

        var option = utils.nextInt();
        switch (option) {
            case 1:
                showAddCandidateMenu();
                break;
            case 2:
                showRemoveCandidateMenu();
                break;
            case 3:
                showBestCafes();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid input");
                utils.getInput();
                break;
        }
        showBestCafeMenu();
    }
}
