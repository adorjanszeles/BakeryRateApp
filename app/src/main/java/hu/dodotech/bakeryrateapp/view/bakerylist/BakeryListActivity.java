package hu.dodotech.bakeryrateapp.view.bakerylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;

public class BakeryListActivity extends AppCompatActivity implements BakeryListScreen {

    @Inject
    BakeryListPresenter bakeryListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BakeryApp.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bakeryListPresenter.attachScreen(this);
        bakeryListPresenter.getBakeryItems();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bakeryListPresenter.detachScreen();
    }

    @Override
    public void showBakeryList(List<Bakery> bakeryList) {
        Log.i(this.getClass().getName(), "Dependency Injection works fine...");
    }
}
