package hu.dodotech.bakeryrateapp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import hu.dodotech.bakeryrateapp.view.UIModule;

public class BakeryApp extends Application {
    public static BakeryAppComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerBakeryAppComponent.builder().uIModule(new UIModule()).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
