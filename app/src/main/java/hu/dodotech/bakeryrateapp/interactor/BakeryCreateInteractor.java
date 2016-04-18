package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.User;

public class BakeryCreateInteractor {
    @Inject
    protected Bakery bakery;
    @Inject
    protected User user;

    public BakeryCreateInteractor() {
        BakeryApp.injector.inject(this);
    }
}
