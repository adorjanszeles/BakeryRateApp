package hu.dodotech.bakeryrateapp.model;

import java.util.List;

import hu.dodotech.bakeryrateapp.common.SearchItem;

public interface BakeryDal {
    List<Bakery> listAllBakeryItems(Class<?> pClass);
    List<Bakery> listQueryBakery(Class<?> pClass, SearchItem searchItem);
    void addBakery(Bakery bakery);
    void deleteBakery(Bakery bakery);
    //void modifyBakery(Bakery bakery);
    void rateBakery(Bakery bakery);
}
