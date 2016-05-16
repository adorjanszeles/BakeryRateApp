package hu.dodotech.bakeryrateapp.unittests.network;

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
import hu.dodotech.bakeryrateapp.network.BakeryApi;
import hu.dodotech.bakeryrateapp.network.mock.BakeryMock;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class NetworkTest {
    @Inject
    protected BakeryApi bakeryApi;

    @Before
    public void setUp() throws Exception {
        BakeryApp app = TestHelper.setTestInjector();
        ((TestComponent) app.getInjector()).inject(this);
    }

    @Test
    public void testInjectionOk() throws Exception {
        assertNotEquals(null, bakeryApi);
    }

    @Test
    public void testGetAllBakeryItems() throws Exception {
        BakeryMock.clearList();
        if(BuildConfig.FLAVOR.equals("mock")) {
            Response response = bakeryApi.getAllBakeryItemsGet().execute();
            List<Bakery> bakeryList = (List<Bakery>)response.body();
            int responseListSize = bakeryList.size();
            String firstElementName = bakeryList.get(0).getName();
            String secondElementName = bakeryList.get(1).getName();
            assertEquals(2, responseListSize);
            assertEquals("Valami", firstElementName);
            assertEquals("Csiga", secondElementName);
        }
    }

    @Test
    public void testAddBakeryItems() throws Exception {
        BakeryMock.clearList();
        if(BuildConfig.FLAVOR.equals("mock")) {
            Bakery bak = new Bakery();
            bak.setName("test bak");
            bakeryApi.createBakeryPost(bak).execute();
            Response response = bakeryApi.getAllBakeryItemsGet().execute();
            List<Bakery> bakeryList = (List<Bakery>)response.body();
            int responseListSize = bakeryList.size();
            String name = bakeryList.get(2).getName();
            assertEquals(3, responseListSize);
            assertEquals("test bak", name);
        }
    }

    @Test
    public void testDeleteBakeryItems() throws Exception {
        BakeryMock.clearList();
        if(BuildConfig.FLAVOR.equals("mock")) {
            Response response = bakeryApi.getAllBakeryItemsGet().execute();
            List<Bakery> bakeryListBeforeDelete = (List<Bakery>)response.body();
            int responseListSizeBeforeDelete = bakeryListBeforeDelete.size();
            bakeryApi.deleteBakeryBakeryIdPost(bakeryListBeforeDelete.get(0)).execute();
            response = bakeryApi.getAllBakeryItemsGet().execute();
            List<Bakery> bakeryListAfterDelete = (List<Bakery>)response.body();
            int responseListSizeAfterDelete = bakeryListAfterDelete.size();
            String afterDeleteName = bakeryListAfterDelete.get(0).getName();
            assertEquals(2, responseListSizeBeforeDelete);
            assertEquals(1, responseListSizeAfterDelete);
            assertEquals("Csiga", afterDeleteName);
        }
    }

    @Test
    public void testQueryBakeryItems() throws Exception {
        BakeryMock.clearList();
        if(BuildConfig.FLAVOR.equals("mock")) {
            SearchItem item = new SearchItem();
            item.setName("Csiga");
            Response response = bakeryApi.getBakeryItemsByConditionsGet(item).execute();
            List<Bakery> resultList = (List<Bakery>)response.body();
            int resultListSize = resultList.size();
            String resultName = resultList.get(0).getName();
            assertEquals(1, resultListSize);
            assertEquals("Csiga", resultName);
        }
    }

    @Test
    public void testRateFunction() throws Exception {
        BakeryMock.clearList();
        if(BuildConfig.FLAVOR.equals("mock")) {
            Response response = bakeryApi.getAllBakeryItemsGet().execute();
            List<Bakery> bakeryList = (List<Bakery>)response.body();
            Bakery toRate = bakeryList.get(0);
            RatingHelper.calculatNewRating(toRate, 4);
            bakeryApi.updateBakeryPost(toRate).execute();
            response = bakeryApi.getAllBakeryItemsGet().execute();
            bakeryList = (List<Bakery>)response.body();
            assertEquals(((2D + 4D) / 2D), bakeryList.get(0).getRate(), 0.001);
        }
    }

    @Test
    public void testNetworkCodeError() throws Exception {
        BakeryMock.clearList();
        if(BuildConfig.FLAVOR.equals("mock")) {
            Response response = bakeryApi.testWrongPath().execute();
            int responseCode = response.code();
            assertEquals(404, responseCode);
        }
    }
}
