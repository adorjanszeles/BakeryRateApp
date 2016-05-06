package hu.dodotech.bakeryrateapp.presenter;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.helper.SearchItem;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListScreen;

public class BakeryListPresenter extends AbstractPresenter<BakeryListScreen> {
    @Inject
    protected BakeryListInteractor bakeryListInteractor;

    public BakeryListPresenter() {
        BakeryApp.injector.inject(this);
    }

    public void getAllBakeryItems() {
        List<Bakery> bakeryList = bakeryListInteractor.getBakeryList();
        showBakeries(bakeryList);
    }

    public void queryBakeryItems(SearchItem item) {
        List<Bakery> bakeryList = bakeryListInteractor.queryBakeries(item);
        showBakeries(bakeryList);
    }

    public void showBakeries(List<Bakery> bakeries) {
        screen.showBakeryList(bakeries);
    }
}
