package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
     @Provides
     @Singleton
     public BakeryCreateInteractor provideBakeryCreateInteractor() {
        return new BakeryCreateInteractor();
    }

    @Provides
    @Singleton
    public BakeryListInteractor provideBakeryListInteractor() {
        return new BakeryListInteractor();
    }

    @Provides
    @Singleton
    public BakeryDetailsInteractor provideBakeryDetailsInteractor() {
        return new BakeryDetailsInteractor();
    }
}
