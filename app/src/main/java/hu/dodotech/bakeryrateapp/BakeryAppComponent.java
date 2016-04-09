package hu.dodotech.bakeryrateapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.dodotech.bakeryrateapp.view.UIModule;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface BakeryAppComponent {
    void inject(BakeryListActivity bakeryListActivity);
}
