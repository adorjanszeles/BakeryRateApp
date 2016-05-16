package hu.dodotech.bakeryrateapp.unittests.interactor;

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
import hu.dodotech.bakeryrateapp.interactor.BakeryCreateInteractor;
import hu.dodotech.bakeryrateapp.interactor.BakeryDetailsInteractor;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.network.mock.BakeryMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class InteractorTest {
    @Inject
    protected BakeryCreateInteractor bakeryCreateInteractor;

    @Inject
    protected BakeryDetailsInteractor bakeryDetailsInteractor;

    @Inject
    protected BakeryListInteractor bakeryListInteractor;

    @Before
    public void setUp() throws Exception {
        BakeryApp app = TestHelper.setTestInjector();
        ((TestComponent) app.getInjector()).inject(this);
    }

    @Test
    public void testInjectionOk() throws Exception {
        assertNotEquals(null, bakeryCreateInteractor);
        assertNotEquals(null, bakeryDetailsInteractor);
        assertNotEquals(null, bakeryListInteractor);
    }

    @Test
    public void testGetAllBakeryItems() throws Exception {
        BakeryMock.clearList();
        List<Bakery> bakeryList = bakeryListInteractor.getBakeryListFromNetwork();
        int responseListSize = bakeryList.size();
        String firstElementName = bakeryList.get(0).getName();
        String secondElementName = bakeryList.get(1).getName();
        assertEquals(2, responseListSize);
        assertEquals("Valami", firstElementName);
        assertEquals("Csiga", secondElementName);
    }

    @Test
    public void testAddBakeryItems() throws Exception {
        BakeryMock.clearList();
        Bakery bak = new Bakery();
        bak.setName("test bak");
        bakeryCreateInteractor.addBakeryToNetwork(bak);
        List<Bakery> bakeryList = bakeryListInteractor.getBakeryListFromNetwork();
        int responseListSize = bakeryList.size();
        String name = bakeryList.get(2).getName();
        assertEquals(3, responseListSize);
        assertEquals("test bak", name);
    }

    @Test
    public void testDeleteBakeryItems() throws Exception {
        BakeryMock.clearList();
        List<Bakery> bakeryListBeforeDelete = bakeryListInteractor.getBakeryListFromNetwork();
        int responseListSizeBeforeDelete = bakeryListBeforeDelete.size();
        bakeryDetailsInteractor.deleteBakeryFromNetwork(bakeryListBeforeDelete.get(0));
        List<Bakery> bakeryListAfterDelete = bakeryListInteractor.getBakeryListFromNetwork();
        int responseListSizeAfterDelete = bakeryListAfterDelete.size();
        String afterDeleteName = bakeryListAfterDelete.get(0).getName();
        assertEquals(2, responseListSizeBeforeDelete);
        assertEquals(1, responseListSizeAfterDelete);
        assertEquals("Csiga", afterDeleteName);
    }

    @Test
    public void testQueryBakeryItems() throws Exception {
        BakeryMock.clearList();
        SearchItem item = new SearchItem();
        item.setName("Csiga");
        List<Bakery> resultList = bakeryListInteractor.getBakeryListByConditionsFromNetwork(item);
        int resultListSize = resultList.size();
        String resultName = resultList.get(0).getName();
        assertEquals(1, resultListSize);
        assertEquals("Csiga", resultName);
    }

    @Test
    public void testRateFunction() throws Exception {
        BakeryMock.clearList();
        List<Bakery> bakeryList = bakeryListInteractor.getBakeryListFromNetwork();
        Bakery toRate = bakeryList.get(0);
        RatingHelper.calculatNewRating(toRate, 4);
        bakeryDetailsInteractor.modifyBakeryRatingsInNetwork(toRate);
        bakeryList = bakeryListInteractor.getBakeryListFromNetwork();
        assertEquals(((2D + 4D) / 2D), bakeryList.get(0).getRate(), 0.001);
    }

    @Test
    public void testNetworkOnExecuteError() throws Exception {
        BakeryMock.clearList();
        BakeryMock.setIsInitialisedFalse();
        String exception = "";
        try {
            bakeryListInteractor.getBakeryListFromNetwork();
        } catch(Exception e) {
            exception = e.getMessage();
        } finally {
            assertEquals("Network error on execute!", exception);
        }
    }
}
