package hu.dodotech.bakeryrateapp.presenter;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListScreen;

public class BakeryListPresenter extends AbstractPresenter<BakeryListScreen> {
    @Inject
    protected BakeryListInteractor bakeryListInteractor;

    public BakeryListPresenter() {
        BakeryApp.injector.inject(this);
    }

    @Override
    public void attachScreen(BakeryListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getBakeryItems() {
        List<Bakery> bakeryList = bakeryListInteractor.getBakeryList();
        screen.showBakeryList(bakeryList);
    }
}
