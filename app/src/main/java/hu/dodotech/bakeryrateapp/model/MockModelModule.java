package hu.dodotech.bakeryrateapp.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;
import hu.dodotech.bakeryrateapp.model.bakery.MockBakery;
import hu.dodotech.bakeryrateapp.model.user.MockUser;
import hu.dodotech.bakeryrateapp.model.user.UserDal;

@Module
public class MockModelModule {
    @Provides
    @Singleton
    public BakeryDal provideMockBakery() {
        return new MockBakery();
    }

    @Provides
    @Singleton
    public UserDal provideMockUser() {
        return new MockUser();
    }
}
