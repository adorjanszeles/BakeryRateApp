package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;

public class BakeryDetailsInteractor {
    @Inject
    protected BakeryDal bakery;

    public BakeryDetailsInteractor() {
        BakeryApp.injector.inject(this);
    }

    public void modifyBakeryRatings(Bakery bak) {
        bakery.rateBakery(bak);
    }
}
