package hu.dodotech.bakeryrateapp.presenter;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.LoginAndRegisterInteractor;
import hu.dodotech.bakeryrateapp.view.login.LoginAndRegisterScreen;

public class LoginAndRegisterPresenter extends AbstractPresenter<LoginAndRegisterScreen> {
    @Inject
    protected LoginAndRegisterInteractor loginAndRegisterInteractor;

    public LoginAndRegisterPresenter() {
        BakeryApp.injector.inject(this);
    }
}
