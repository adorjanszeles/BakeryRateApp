package hu.dodotech.bakeryrateapp.network;

import java.util.List;

import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.model.Bakery;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BakeryApi {
    /**
     * Create a `Bakery` objects.
     * @param bakery Bakery to save
     * @return Call<Void>
     */
    @POST("createBakery")
    Call<Void> createBakeryPost(@Body Bakery bakery);


    /**
     * Delete a `Bakery` objects.
     * @param bakery Bakery to delete
     * @return Call<Void>
     */
    @POST("deleteBakery")
    Call<Void> deleteBakeryBakeryIdPost(@Body Bakery bakery);

    /**
     * Get all `Bakery` objects in array.
     * @return Call<List<Bakery>>
     */
    @GET("getAllBakeryItems")
    Call<List<Bakery>> getAllBakeryItemsGet();

    /**
     * Gets `Bakery` objects by conditions.
     * @param bakerySearchItem The search condition object
     * @return Call<List<Bakery>>
     */
    @POST("getBakeryItemsByConditions")
    Call<List<Bakery>> getBakeryItemsByConditionsGet(@Body SearchItem bakerySearchItem);

    /**
     * Update a `Bakery` objects.
     * @param bakery Bakery to update
     * @return Call<Void>
     */
    @POST("updateBakery")
    Call<Void> updateBakeryPost(@Body Bakery bakery);

    /**
     * Helper method to test wrong path logic.
     * @return
     */
    @GET("wrongPath")
    Call<Void> testWrongPath();
}
