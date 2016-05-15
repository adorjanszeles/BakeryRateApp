package hu.dodotech.bakeryrateapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.dodotech.bakeryrateapp.interactor.InteractorModule;
import hu.dodotech.bakeryrateapp.network.mock.MockNetworkModule;
import hu.dodotech.bakeryrateapp.unittests.model.BakeryDalTest;
import hu.dodotech.bakeryrateapp.view.UIModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, UIModule.class})
public interface TestComponent extends BakeryAppComponent{
    void inject(BakeryDalTest bakeryDalTest);
}
