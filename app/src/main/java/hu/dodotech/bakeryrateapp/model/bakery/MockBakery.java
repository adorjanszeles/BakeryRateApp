package hu.dodotech.bakeryrateapp.model.bakery;

import java.util.ArrayList;
import java.util.List;

import hu.dodotech.bakeryrateapp.R;

public class MockBakery implements BakeryDal {
    @Override
    public List<Bakery> listAllBakeryItems(Class<?> pClass) {
        List<Bakery> result = new ArrayList<>();

        Bakery bak1 = new Bakery();
        bak1.setId(1L);
        bak1.setName("Kakóscsiga");
        bak1.setBakeryImageResourceId(R.drawable.cocoa);
        bak1.setRateImageResourceId(R.drawable.rate_star);

        Bakery bak2 = new Bakery();
        bak2.setId(2L);
        bak2.setName("Túróstáska");
        bak2.setBakeryImageResourceId(R.drawable.turos_taska);
        bak2.setRateImageResourceId(R.drawable.rate_star);

        Bakery bak3 = new Bakery();
        bak3.setId(3L);
        bak3.setName("Gesztenyés Croissant");
        bak3.setBakeryImageResourceId(R.drawable.croissant);
        bak3.setRateImageResourceId(R.drawable.rate_star);

        Bakery bak4 = new Bakery();
        bak4.setId(4L);
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
