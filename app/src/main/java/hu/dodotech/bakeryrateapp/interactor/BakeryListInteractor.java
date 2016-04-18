package hu.dodotech.bakeryrateapp.interactor;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;
import hu.dodotech.bakeryrateapp.model.user.UserDal;

public class BakeryListInteractor {
    @Inject
    protected BakeryDal bakery;
    @Inject
    protected UserDal user;

    public BakeryListInteractor() {
        BakeryApp.injector.inject(this);
    }

    public List<Bakery> getBakeryList() {
        return bakery.listAllBakeryItems(Bakery.class);
    }
}
