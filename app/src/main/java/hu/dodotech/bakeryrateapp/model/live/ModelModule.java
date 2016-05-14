package hu.dodotech.bakeryrateapp.model.live;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.BakeryDal;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public BakeryDal provideBakery() {
        return new BakeryModel();
    }
}
