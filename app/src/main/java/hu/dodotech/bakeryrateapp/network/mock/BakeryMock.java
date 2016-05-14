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
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

public class BakeryMock {
    private static List<Bakery> bakeryList = new ArrayList<>();
    private static boolean isInitialised = false;
    private static Bakery bakery1 = new Bakery();
    private static Bakery bakery2 = new Bakery();
    private static long uniqueId = 0;

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "getAllBakeryItems") && request.method().equals("GET")) {
            return processGetAllBakeryItems(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "createBakery") && request.method().equals("POST")) {
            return processCreateBakery(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "getBakeryItemsByConditions") && request.method().equals("GET")) {
           return processGetBakeryItemsByConditions(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "updateBakery") && request.method().equals("POST")) {
            return processUpdateBakery(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "deleteBakery") && request.method().equals("POST")) {
            return processDeleteBakery(request);
        } else {
            responseString = "ERROR";
            responseCode = 503;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processGetAllBakeryItems(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        if (!isInitialised) {
            bakery1.setRate(2.8D);
            bakery1.setAddress("Valahol");
            bakery1.setDetails("Nagyon király valami");
            bakery1.setName("Valami");
            bakery1.setBakeryImageResourceId(R.drawable.perec);
            bakery1.setId(uniqueId++);
            bakery2.setRate(3.8D);
            bakery2.setAddress("Örs");
            bakery2.setDetails("Egész jó csiga!");
            bakery2.setName("Csiga");
            bakery2.setBakeryImageResourceId(R.drawable.cocoa);
            bakery2.setId(uniqueId++);
            bakeryList.add(bakery1);
            bakeryList.add(bakery2);
            isInitialised = true;
        }
        responseString = GsonHelper.getGson().toJson(bakeryList);
        responseCode = 200;
        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    private static Response processCreateBakery(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Bakery bakery = GsonHelper.getGson().getAdapter(Bakery.class).fromJson(buffer.readUtf8());
            bakery.setId(uniqueId++);
            bakeryList.add(bakery);
            responseString = "";
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processUpdateBakery(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Bakery bakery = GsonHelper.getGson().getAdapter(Bakery.class).fromJson(buffer.readUtf8());
            bakeryList.remove(bakery);
            bakeryList.add(bakery);
            responseString = "";
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processDeleteBakery(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Bakery bakery = GsonHelper.getGson().getAdapter(Bakery.class).fromJson(buffer.readUtf8());
            bakeryList.remove(bakery);
            responseString = "";
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processGetBakeryItemsByConditions(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        List<Bakery> result = null;
        // TODO search implement...
        responseString = GsonHelper.getGson().toJson(result);
        responseCode = 200;
        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }
}
