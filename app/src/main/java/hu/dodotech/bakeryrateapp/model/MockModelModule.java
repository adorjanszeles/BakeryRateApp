package hu.dodotech.bakeryrateapp.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;
import hu.dodotech.bakeryrateapp.model.bakery.MockBakery;

@Module
public class MockModelModule {
    @Provides
    @Singleton
    public BakeryDal provideMockBakery() {
        return new MockBakery();
    }
}
