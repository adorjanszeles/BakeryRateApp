package hu.dodotech.bakeryrateapp.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public Bakery getBakery() {
        return new Bakery();
    }
}
