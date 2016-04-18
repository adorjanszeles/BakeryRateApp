package hu.dodotech.bakeryrateapp.interactor;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.User;

public class BakeryListInteractor {
    @Inject
    protected Bakery bakery;
    @Inject
    protected User user;

    public BakeryListInteractor() {
        BakeryApp.injector.inject(this);
    }

    public List<Bakery> getBakeryList() {
        return Bakery.listAll(Bakery.class);
    }
}
