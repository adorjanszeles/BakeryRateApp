package hu.dodotech.bakeryrateapp;

import android.app.Application;

import hu.dodotech.bakeryrateapp.interactor.InteractorModule;
import hu.dodotech.bakeryrateapp.view.UIModule;

public class BakeryApp extends Application {
    public static BakeryAppComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerBakeryAppComponent.builder().uIModule(new UIModule()).build();
    }
}
