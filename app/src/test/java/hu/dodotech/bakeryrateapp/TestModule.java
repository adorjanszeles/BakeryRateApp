package hu.dodotech.bakeryrateapp;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.model.BakeryDal;
import hu.dodotech.bakeryrateapp.model.mock.MockBakeryModel;

@Module
public class TestModule {
    @Provides
    public BakeryDal providesBakeryDal() {
        return new MockBakeryModel();
    }
}
