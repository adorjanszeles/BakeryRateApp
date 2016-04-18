package hu.dodotech.bakeryrateapp.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListScreen;

public class BakeryListPresenter extends AbstractPresenter<BakeryListScreen> {
    @Inject
    protected BakeryListInteractor bakeryListInteractor;

    public BakeryListPresenter() {
        BakeryApp.injector.inject(this);
    }

    @Override
    public void attachScreen(BakeryListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getBakeryItems() {
        // TODO get the bakery list items
        List<Bakery> bakeryList = createMockItems();
        screen.showBakeryList(bakeryList);
    }

    /**
     * Mock tool, need to remove soon...
     */
    private List<Bakery> createMockItems() {
        List<Bakery> result = new ArrayList<>();

        Bakery bak1 = new Bakery();
        bak1.setId(1);
        bak1.setName("Kakóscsiga");
        bak1.setBakeryImageResourceId(R.drawable.cocoa);
        bak1.setRateImageResourceId(R.drawable.rate_star);

        Bakery bak2 = new Bakery();
        bak2.setId(2);
        bak2.setName("Túróstáska");
        bak2.setBakeryImageResourceId(R.drawable.turos_taska);
        bak2.setRateImageResourceId(R.drawable.rate_star);

        Bakery bak3 = new Bakery();
        bak3.setId(3);
        bak3.setName("Gesztenyés Croissant");
        bak3.setBakeryImageResourceId(R.drawable.croissant);
        bak3.setRateImageResourceId(R.drawable.rate_star);

        Bakery bak4 = new Bakery();
        bak4.setId(4);
        bak4.setName("Perec");
        bak4.setBakeryImageResourceId(R.drawable.perec);
        bak4.setRateImageResourceId(R.drawable.rate_star);

        result.add(bak1);
        result.add(bak2);
        result.add(bak3);
        result.add(bak4);

        return result;
    }
}
