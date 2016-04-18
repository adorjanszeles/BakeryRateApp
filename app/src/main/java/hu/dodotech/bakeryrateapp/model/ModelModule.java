package hu.dodotech.bakeryrateapp.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.bakery.BakeryDal;
import hu.dodotech.bakeryrateapp.model.user.User;
import hu.dodotech.bakeryrateapp.model.user.UserDal;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public BakeryDal provideBakery() {
        return new Bakery();
    }

    @Provides
    @Singleton
    public UserDal provideUser() {
        return new User();
    }
}
