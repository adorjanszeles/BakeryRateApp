package hu.dodotech.bakeryrateapp.presenter;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryDetailsInteractor;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.view.bakerydetails.BakeryDetailsScreen;

public class BakeryDetailsPresenter extends AbstractPresenter<BakeryDetailsScreen> {
    @Inject
    protected BakeryDetailsInteractor bakeryDetailsInteractor;

    public BakeryDetailsPresenter() {
        BakeryApp.injector.inject(this);
    }

    public void modifyBakeryRatings(Bakery bakery) {
        try {
            bakeryDetailsInteractor.modifyBakeryRatingsInNetwork(bakery);
            screen.showAllBakery();
        } catch (Exception e) {
            bakeryDetailsInteractor.modifyBakeryRatingsInDb(bakery);
            screen.showAllBakery();
            screen.showMessage(e.getMessage());
        }
    }
}
