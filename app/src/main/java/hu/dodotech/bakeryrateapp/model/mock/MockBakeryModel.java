package hu.dodotech.bakeryrateapp.model.mock;

import java.util.ArrayList;
import java.util.List;

import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.common.ListSearchHelper;
import hu.dodotech.bakeryrateapp.common.RatingHelper;
import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.BakeryDal;

public class MockBakeryModel implements BakeryDal {
    private static List<Bakery> bakeryList;
    private static long uniqueId;

    public MockBakeryModel() {
        bakeryList = new ArrayList<>();
        uniqueId = 0;

        Bakery bak1 = new Bakery();
        bak1.setId(uniqueId++);
        bak1.setName("Kakóscsiga");
        bak1.setBakeryImageResourceId(R.drawable.cocoa);
        bak1.setAddress("Műegyetem pékség");
        bak1.setDetails("Ez aztán a csokis csiga!");
        RatingHelper.calculatNewRating(bak1, 4);

        Bakery bak2 = new Bakery();
        bak2.setId(uniqueId++);
        bak2.setName("Túróstáska");
        bak2.setAddress("Kolosy tér 12.");
        bak2.setDetails("Nem a legjobb túrós... :(");
        bak2.setBakeryImageResourceId(R.drawable.turos_taska);
        RatingHelper.calculatNewRating(bak2, 2);

        Bakery bak3 = new Bakery();
        bak3.setId(uniqueId++);
        bak3.setName("Gesztenyés Croissant");
        bak3.setAddress("Nyugati aluljáró");
        bak3.setDetails("Ez valami szörnyű volt... :(");
        bak3.setBakeryImageResourceId(R.drawable.croissant);
        RatingHelper.calculatNewRating(bak3, 5);

        Bakery bak4 = new Bakery();
        bak4.setId(uniqueId++);
        bak4.setName("Perec");
        bak4.setAddress("Kiskőrösi út 12.");
        bak4.setDetails("Legjobb perec ever... :) :)");
        bak4.setBakeryImageResourceId(R.drawable.perec);
        RatingHelper.calculatNewRating(bak4, 3);

        bakeryList.add(bak1);
        bakeryList.add(bak2);
        bakeryList.add(bak3);
        bakeryList.add(bak4);
    }

    @Override
    public List<Bakery> listAllBakeryItems(Class<?> pClass) {
        return bakeryList;
    }

    @Override
    public List<Bakery> listQueryBakery(Class<?> pClass, SearchItem searchItem) {
        return ListSearchHelper.searchByConditions(bakeryList, searchItem);
    }

    @Override
    public void addBakery(Bakery bakery) {
        bakery.setId(uniqueId++);
        bakeryList.add(bakery);
    }

    @Override
    public void deleteBakery(Bakery bakery) {
        bakeryList.remove(bakery);
    }

    @Override
    public void rateBakery(Bakery bakery) {
        bakeryList.remove(bakery);
        bakeryList.add(bakery);
    }
}
