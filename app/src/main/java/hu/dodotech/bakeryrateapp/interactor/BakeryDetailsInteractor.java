package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.BakeryDal;
import hu.dodotech.bakeryrateapp.network.BakeryApi;
import retrofit2.Response;

public class BakeryDetailsInteractor {
    @Inject
    protected BakeryDal bakeryDal;

    @Inject
    protected BakeryApi bakeryApi;

    public BakeryDetailsInteractor() {
        BakeryApp.injector.inject(this);
    }

    public void modifyBakeryRatingsInDb(Bakery bak) {
        bakeryDal.rateBakery(bak);
    }

    public void modifyBakeryRatingsInNetwork(Bakery bak) throws Exception {
        Response response;
        try {
            response = bakeryApi.updateBakeryPost(bak).execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }

    public void deleteBakeryFromDb(Bakery bak) {
        bakeryDal.deleteBakery(bak);
    }

    public void deleteBakeryFromNetwork(Bakery bak) throws Exception {
        Response response;
        try {
            response = bakeryApi.deleteBakeryBakeryIdPost(bak).execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }
}
