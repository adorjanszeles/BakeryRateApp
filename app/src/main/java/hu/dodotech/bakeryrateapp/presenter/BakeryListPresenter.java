package hu.dodotech.bakeryrateapp.presenter;

import java.util.List;

import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListScreen;

public class BakeryListPresenter extends AbstractPresenter<BakeryListScreen> {

    @Override
    public void attachScreen(BakeryListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getBakeryItems() {
        // TODO get the bakery list items
        List<Bakery> bakeryList = null;
        screen.showBakeryList(bakeryList);
    }
}
