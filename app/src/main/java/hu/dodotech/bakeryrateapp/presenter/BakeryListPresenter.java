package hu.dodotech.bakeryrateapp.presenter;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListScreen;

public class BakeryListPresenter extends AbstractPresenter<BakeryListScreen> {
    @Inject
    protected BakeryListInteractor bakeryListInteractor;

    public BakeryListPresenter() {
        BakeryApp.injector.inject(this);
    }

    public void getAllBakeryItems() {
        List<Bakery> bakeryList;
        try {
            bakeryList = bakeryListInteractor.getBakeryListFromNetwork();
            showBakeries(bakeryList);
        } catch(Exception e) {
            bakeryList = bakeryListInteractor.getBakeryListFromDb();
            showBakeries(bakeryList);
            screen.showMessage(e.getMessage());
        }
    }

    public void queryBakeryItems(SearchItem item) {
        List<Bakery> bakeryList;
        try {
            bakeryList = bakeryListInteractor.getBakeryListByConditionsFromNetwork(item);
            showBakeries(bakeryList);
        } catch(Exception e) {
            bakeryList = bakeryListInteractor.getBakeryListByConditionsFromDb(item);
            showBakeries(bakeryList);
            screen.showMessage(e.getMessage());
        }
    }

    private void showBakeries(List<Bakery> bakeries) {
        screen.showBakeryList(bakeries);
    }
}
