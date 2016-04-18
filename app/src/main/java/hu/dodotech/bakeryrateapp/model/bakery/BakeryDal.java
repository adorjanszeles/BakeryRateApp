package hu.dodotech.bakeryrateapp.model.bakery;

import java.util.List;

public interface BakeryDal {
    List<Bakery> listAllBakeryItems(Class<?> pClass);
}
