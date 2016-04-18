package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;
import hu.dodotech.bakeryrateapp.model.user.UserDal;

public class BakeryCreateInteractor {
    @Inject
    protected BakeryDal bakery;
    @Inject
    protected UserDal user;

    public BakeryCreateInteractor() {
        BakeryApp.injector.inject(this);
    }
}
