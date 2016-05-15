package hu.dodotech.bakeryrateapp.unittests.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.BuildConfig;
import hu.dodotech.bakeryrateapp.RobolectricDaggerTestRunner;
import hu.dodotech.bakeryrateapp.TestComponent;
import hu.dodotech.bakeryrateapp.TestHelper;
import hu.dodotech.bakeryrateapp.common.RatingHelper;
import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.model.BakeryDal;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class BakeryDalTest {
    @Inject
    public BakeryDal bakeryDal;

    @Before
    public void setUp() throws Exception {
        BakeryApp app = TestHelper.setTestInjector();
        ((TestComponent) app.getInjector()).inject(this);
    }

    @Test
    public void testInitializeOkByBakeryCount() throws Exception {
        int numberOfAddedBakeries = bakeryDal.listAllBakeryItems(Bakery.class).size();
        assertEquals(4, numberOfAddedBakeries);
    }

    @Test
    public void firstElementCheckByAttributes() throws Exception {
        String firstElementName = bakeryDal.listAllBakeryItems(Bakery.class).get(0).getName();
        String firstElementAddress = bakeryDal.listAllBakeryItems(Bakery.class).get(0).getAddress();
        String firstElementDetails = bakeryDal.listAllBakeryItems(Bakery.class).get(0).getDetails();
        long firstElementId = bakeryDal.listAllBakeryItems(Bakery.class).get(0).getId();
        double firstElementRate = bakeryDal.listAllBakeryItems(Bakery.class).get(0).getRate();
        assertEquals("Kakóscsiga", firstElementName);
        assertEquals("Műegyetem pékség", firstElementAddress);
        assertEquals("Ez aztán a csokis csiga!", firstElementDetails);
        assertEquals(0, firstElementId);
        assertEquals(4, firstElementRate, 0.1);
    }

    @Test
    public void addBakeryTest() throws Exception {
        Bakery bak5 = new Bakery();
        bak5.setName("Test bak");
        bakeryDal.addBakery(bak5);
        List<Bakery> bakeries = bakeryDal.listAllBakeryItems(Bakery.class);
        String bak5Name = bakeries.get(4).getName();
        long bak5Id = bakeries.get(4).getId();
        int listCount = bakeries.size();
        assertEquals("Test bak", bak5Name);
        assertEquals(4, bak5Id);
        assertEquals(5, listCount);
    }

    @Test
    public void deleteBakeryTest() throws Exception {
        Bakery toDelete = bakeryDal.listAllBakeryItems(Bakery.class).get(0);
        bakeryDal.deleteBakery(toDelete);
        int listCountAfterDelete = bakeryDal.listAllBakeryItems(Bakery.class).size();
        assertEquals(3, listCountAfterDelete);
    }

    @Test
    public void searchByOnlyName() throws Exception {
        SearchItem item = new SearchItem();
        item.setName("csiga");
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String name = resultList.get(0).getName();
        assertEquals(1, listSize);
        assertEquals("Kakóscsiga", name);
    }

    @Test
    public void searchByOnlyAddress() throws Exception {
        SearchItem item = new SearchItem();
        item.setAddress("olosy");
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String address = resultList.get(0).getAddress();
        assertEquals(1, listSize);
        assertEquals("Kolosy tér 12.", address);
    }

    @Test
    public void searchByOnlyRate() throws Exception {
        SearchItem item = new SearchItem();
        item.setRate(4D);
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String firstName = resultList.get(0).getName();
        String secondName = resultList.get(1).getName();
        assertEquals(2, listSize);
        assertEquals("Kakóscsiga", firstName);
        assertEquals("Gesztenyés Croissant", secondName);
    }

    @Test
    public void searchByAddressAndName() throws Exception {
        SearchItem item = new SearchItem();
        item.setName("Kakóscsiga");
        item.setAddress("Műegyetem pékség");
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String name = resultList.get(0).getName();
        assertEquals(1, listSize);
        assertEquals("Kakóscsiga", name);
    }

    @Test
    public void searchByRateAndName() throws Exception {
        SearchItem item = new SearchItem();
        item.setName("Perec");
        item.setRate(3D);
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String name = resultList.get(0).getName();
        assertEquals(1, listSize);
        assertEquals("Perec", name);
    }

    @Test
    public void searchByRateAndAddress() throws Exception {
        SearchItem item = new SearchItem();
        item.setAddress("Kiskőrösi út 12.");
        item.setRate(3D);
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String name = resultList.get(0).getName();
        assertEquals(1, listSize);
        assertEquals("Perec", name);
    }

    @Test
    public void searchByRateAndAddressAndName() throws Exception {
        SearchItem item = new SearchItem();
        item.setName("Perec");
        item.setAddress("Kiskőrösi út 12.");
        item.setRate(2D);
        List<Bakery> resultList = bakeryDal.listQueryBakery(Bakery.class, item);
        int listSize = resultList.size();
        String name = resultList.get(0).getName();
        assertEquals(1, listSize);
        assertEquals("Perec", name);
    }

    @Test
    public void testRateFunction() throws Exception {
        List<Bakery> resultList = bakeryDal.listAllBakeryItems(Bakery.class);
        Bakery toRate = resultList.get(0);
        RatingHelper.calculatNewRating(toRate, 2);
        bakeryDal.rateBakery(toRate);
        Bakery afterRate = bakeryDal.listAllBakeryItems(Bakery.class).get(3);
        double rate = afterRate.getRate();
        assertEquals(((4.0D + 2.0D) / 2.0D), rate, 0.001);
    }
}
