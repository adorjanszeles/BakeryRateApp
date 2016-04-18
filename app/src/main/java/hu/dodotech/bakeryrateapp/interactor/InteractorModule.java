package hu.dodotech.bakeryrateapp.interactor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.interactor.BakeryCreateInteractor;

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

    @Provides
    @Singleton
    public LoginAndRegisterInteractor provideLoginAndRegisterInteractor() {
        return new LoginAndRegisterInteractor();
    }

}
