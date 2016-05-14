package hu.dodotech.bakeryrateapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.dodotech.bakeryrateapp.interactor.InteractorModule;
import hu.dodotech.bakeryrateapp.model.mock.MockModelModule;
import hu.dodotech.bakeryrateapp.network.mock.MockNetworkModule;
import hu.dodotech.bakeryrateapp.view.UIModule;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, MockModelModule.class, MockNetworkModule.class})
public interface MockBakeryAppComponent extends BakeryAppComponent{}
