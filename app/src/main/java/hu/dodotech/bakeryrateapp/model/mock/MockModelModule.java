package hu.dodotech.bakeryrateapp.model.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.BakeryDal;

@Module
public class MockModelModule {
    @Provides
    @Singleton
    public BakeryDal provideMockBakery() {
        return new MockBakeryModel();
    }
}
