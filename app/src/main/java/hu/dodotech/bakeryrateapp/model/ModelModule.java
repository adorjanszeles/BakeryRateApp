package hu.dodotech.bakeryrateapp.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public BakeryDal provideBakery() {
        return new Bakery();
    }
}
