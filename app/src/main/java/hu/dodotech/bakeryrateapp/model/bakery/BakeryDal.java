package hu.dodotech.bakeryrateapp.model.bakery;

import java.util.List;

import hu.dodotech.bakeryrateapp.model.helper.SearchItem;

public interface BakeryDal {
    List<Bakery> listAllBakeryItems(Class<?> pClass);
    List<Bakery> listQueryBakery(SearchItem searchItem);
    void addBakery(Bakery bakery);
    void deleteBakery(Bakery bakery);
    void modifyBakery(Bakery bakery);
    void rateBakery(Bakery bakery);
}
