package view;

import controller.BestCafeFinder;
import util.Utils;

public class BestCafeOptimisedView extends BestCafeView {
    public BestCafeOptimisedView(BestCafeFinder bestCafeFinder, Utils utils) {
        super(bestCafeFinder, utils);
    }

    @Override
    protected void showBestCafes() {
        var bestCafes = bestCafeFinder.getBestCafePlacesOptimized();
        System.out.println("Best cafes:");
        for (var node : bestCafes)
            System.out.print(node.getNodeLabel() + " ");
        System.out.println();
        utils.getInput();
    }
}
