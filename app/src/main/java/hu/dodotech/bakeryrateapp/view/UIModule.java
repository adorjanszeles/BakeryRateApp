package hu.dodotech.bakeryrateapp.view;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;

@Module
public class UIModule {
    @Provides
    @Singleton
    public BakeryListPresenter provideBakeryListPresenter() {
        return new BakeryListPresenter();
    }
}
