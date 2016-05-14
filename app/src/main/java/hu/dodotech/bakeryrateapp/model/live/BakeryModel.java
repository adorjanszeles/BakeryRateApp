package hu.dodotech.bakeryrateapp.model.live;

import java.util.List;

import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.BakeryDal;

public class BakeryModel implements BakeryDal {
    @Override
    public List<Bakery> listAllBakeryItems(Class<?> pClass) {
        return (List<Bakery>)Bakery.listAll(pClass);
    }

    @Override
    public List<Bakery> listQueryBakery(Class<?> pClass, SearchItem searchItem) {
        return (List<Bakery>)Bakery.find(pClass,
                "name = ? AND rate = ? AND address = ?",
                searchItem.getName(),
                Double.toString(searchItem.getRate()),
                searchItem.getAddress());
    }

    @Override
    public void addBakery(Bakery bakery) {
        bakery.save();
    }

    @Override
    public void deleteBakery(Bakery bakery) {
        bakery.delete();
    }

//    @Override
//    public void modifyBakery(Bakery bakery) {
//
//    }

    @Override
    public void rateBakery(Bakery bakery) {
        bakery.save();
    }
}
