package hu.dodotech.bakeryrateapp.presenter;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryDetailsInteractor;
import hu.dodotech.bakeryrateapp.view.bakerydetails.BakeryDetailsScreen;

public class BakeryDetailsPresenter extends AbstractPresenter<BakeryDetailsScreen> {
    @Inject
    protected BakeryDetailsInteractor bakeryDetailsInteractor;

    public BakeryDetailsPresenter() {
        BakeryApp.injector.inject(this);
    }
}
