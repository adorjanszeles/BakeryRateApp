package hu.dodotech.bakeryrateapp.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.network.GsonHelper;
import hu.dodotech.bakeryrateapp.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class BakeryMock {
    private static List<Bakery> bakeryList = new ArrayList<>();
    private static boolean isInitialised = false;
    private static Bakery bakery1 = new Bakery();
    private static Bakery bakery2 = new Bakery();

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "getAllBakeryItems") && request.method().equals("GET")) {
            if (!isInitialised) {
                bakery1.setRate(2.8D);
                bakery1.setAddress("Valahol");
                bakery1.setDetails("Nagyon király valami");
                bakery1.setName("Valami");
                bakery1.setBakeryImageResourceId(R.drawable.perec);
                bakery1.setId(0L);
                bakery2.setRate(3.8D);
                bakery2.setAddress("Örs");
                bakery2.setDetails("Egész jó csiga!");
                bakery2.setName("Csiga");
                bakery2.setBakeryImageResourceId(R.drawable.cocoa);
                bakery2.setId(1L);
                bakeryList.add(bakery1);
                bakeryList.add(bakery2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(bakeryList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "createBakery") && request.method().equals("POST")) {
            // TODO get bakery from body then add to the list...
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }
        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }
}
