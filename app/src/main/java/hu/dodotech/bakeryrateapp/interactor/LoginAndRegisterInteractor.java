package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.User;

public class LoginAndRegisterInteractor {
    @Inject
    protected Bakery bakery;
    @Inject
    protected User user;

    public LoginAndRegisterInteractor() {
        BakeryApp.injector.inject(this);
    }
}
