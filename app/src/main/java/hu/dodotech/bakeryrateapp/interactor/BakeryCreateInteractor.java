package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;

public class BakeryCreateInteractor {
    @Inject
    protected BakeryDal bakery;

    public BakeryCreateInteractor() {
        BakeryApp.injector.inject(this);
    }

    public void addBakery(Bakery bak) {
        bakery.addBakery(bak);
    }
}
