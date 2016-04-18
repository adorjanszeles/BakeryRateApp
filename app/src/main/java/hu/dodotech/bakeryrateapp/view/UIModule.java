package hu.dodotech.bakeryrateapp.view;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.presenter.BakeryCreatePresenter;
import hu.dodotech.bakeryrateapp.presenter.BakeryDetailsPresenter;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;
import hu.dodotech.bakeryrateapp.presenter.LoginAndRegisterPresenter;

@Module
public class UIModule {
    @Provides
    @Singleton
    public BakeryListPresenter provideBakeryListPresenter() {
        return new BakeryListPresenter();
    }

    @Provides
    @Singleton
    public BakeryCreatePresenter provideBakeryCreatePresenter() {
        return new BakeryCreatePresenter();
    }

    @Provides
    @Singleton
    public BakeryDetailsPresenter provideBakeryDetailsPresenter() {
        return new BakeryDetailsPresenter();
    }
    @Provides
    @Singleton
    public LoginAndRegisterPresenter provideLoginAndRegisterPresenter() {
        return new LoginAndRegisterPresenter();
    }
}
