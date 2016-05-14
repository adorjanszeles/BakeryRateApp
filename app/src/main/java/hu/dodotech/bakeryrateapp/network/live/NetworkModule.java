package hu.dodotech.bakeryrateapp.network.live;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.network.BakeryApi;
import hu.dodotech.bakeryrateapp.network.GsonHelper;
import hu.dodotech.bakeryrateapp.network.NetworkConfig;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder clientBuilder = null;
        try {
            clientBuilder = UnsafeClientFactory.getUnsafeClient();
        } catch (Exception ignore) {}
        if (clientBuilder == null) {
            throw new RuntimeException("HttpClient cannot be initialized!");
        }
        return clientBuilder;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public BakeryApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(BakeryApi.class);
    }
}
