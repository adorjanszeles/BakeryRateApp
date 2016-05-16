package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.BakeryDal;
import hu.dodotech.bakeryrateapp.network.BakeryApi;
import retrofit2.Response;

public class BakeryCreateInteractor {
    @Inject
    protected BakeryDal bakeryDal;

    @Inject
    protected BakeryApi bakeryApi;

    public BakeryCreateInteractor() {
        BakeryApp.injector.inject(this);
    }

    public void addBakeryToDb(Bakery bak) {
        bakeryDal.addBakery(bak);
    }

    public void addBakeryToNetwork(Bakery bak) throws Exception {
        Response response;
        try {
            response = bakeryApi.createBakeryPost(bak).execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if(response.code() != 200) {
            throw new Exception("Network error!");
        }
    }
}
