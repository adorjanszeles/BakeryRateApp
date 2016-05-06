package hu.dodotech.bakeryrateapp.view.bakerylist;

import java.util.List;

import hu.dodotech.bakeryrateapp.model.bakery.Bakery;

public interface BakeryListScreen {
    void showBakeryList(List<Bakery> bakeries);
}
