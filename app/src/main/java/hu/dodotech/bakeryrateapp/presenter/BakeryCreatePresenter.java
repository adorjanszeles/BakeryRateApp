package hu.dodotech.bakeryrateapp.presenter;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryCreateInteractor;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.view.bakerycreat.BakeryCreateScreen;

public class BakeryCreatePresenter extends AbstractPresenter<BakeryCreateScreen> {
    @Inject
    protected BakeryCreateInteractor bakeryCreateInteractor;

    public BakeryCreatePresenter() {
        BakeryApp.injector.inject(this);
    }

    public void addBakery(Bakery bakery) {
        try {
            bakeryCreateInteractor.addBakeryToNetwork(bakery);
            screen.showAllBakery();
        } catch(Exception e) {
            bakeryCreateInteractor.addBakeryToDb(bakery);
            screen.showAllBakery();
            screen.showMessage(e.getMessage());
        }
    }

    public void showError(String error) {
        screen.showMessage(error);
    }
}
