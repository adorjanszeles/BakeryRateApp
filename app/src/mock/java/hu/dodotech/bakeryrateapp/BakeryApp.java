package hu.dodotech.bakeryrateapp;

import android.app.Application;

import hu.dodotech.bakeryrateapp.view.UIModule;

public class BakeryApp extends Application {
    public static BakeryAppComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMockBakeryAppComponent.builder().uIModule(new UIModule()).build();
    }

    public void setInjector(BakeryAppComponent injector) {
        BakeryApp.injector = injector;
    }

    public BakeryAppComponent getInjector() {
        return injector;
    }
}
