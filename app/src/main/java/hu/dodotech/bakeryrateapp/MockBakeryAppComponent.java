package hu.dodotech.bakeryrateapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.dodotech.bakeryrateapp.interactor.InteractorModule;
import hu.dodotech.bakeryrateapp.model.MockModelModule;
import hu.dodotech.bakeryrateapp.view.UIModule;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, MockModelModule.class})
public interface MockBakeryAppComponent extends BakeryAppComponent{}
