package hu.dodotech.bakeryrateapp.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockModelModule {
    @Provides
    @Singleton
    public MockBakery provideBakery() {
        return new MockBakery();
    }
}
