package hu.dodotech.bakeryrateapp.presenter;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryCreateInteractor;
import hu.dodotech.bakeryrateapp.view.bakerycreate.BakeryCreateScreen;

public class BakeryCreatePresenter extends AbstractPresenter<BakeryCreateScreen> {
    @Inject
    protected BakeryCreateInteractor bakeryCreateInteractor;

    public BakeryCreatePresenter() {
        BakeryApp.injector.inject(this);
    }
}
