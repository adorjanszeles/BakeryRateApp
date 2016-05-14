package hu.dodotech.bakeryrateapp.interactor;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.BakeryDal;
import hu.dodotech.bakeryrateapp.network.BakeryApi;
import retrofit2.Call;
import retrofit2.Response;

public class BakeryListInteractor {
    @Inject
    protected BakeryDal bakeryDal;

    @Inject
    protected BakeryApi bakeryApi;

    public BakeryListInteractor() {
        BakeryApp.injector.inject(this);
    }

    public List<Bakery> getBakeryListFromDb() {
        return bakeryDal.listAllBakeryItems(Bakery.class);
    }

    public List<Bakery> getBakeryListFromNetwork() throws Exception {
        Response<List<Bakery>> response;

        Call<List<Bakery>> call = bakeryApi.getAllBakeryItemsGet();
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
        return response.body();
    }

    public List<Bakery> getBakeryListByConditionsFromDb(SearchItem searchItem) {
        return bakeryDal.listQueryBakery(Bakery.class, searchItem);
    }

    public List<Bakery> getBakeryListByConditionsFromNetwork(SearchItem item) throws Exception {
        Response<List<Bakery>> response;

        Call<List<Bakery>> call = bakeryApi.getBakeryItemsByConditionsGet(item);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
        return response.body();
    }
}
