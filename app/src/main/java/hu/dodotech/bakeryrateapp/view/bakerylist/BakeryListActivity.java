package hu.dodotech.bakeryrateapp.view.bakerylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;

public class BakeryListActivity extends AppCompatActivity implements BakeryListScreen {
    private ListView listView;
    @Inject
    protected BakeryListPresenter bakeryListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        BakeryApp.injector.inject(this);
        listView = (ListView) findViewById(R.id.bakeryList);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void showBakeryList(List<Bakery> bakeryList) {
        listView.setAdapter(new BakeryListAdapter(this, bakeryList));
        Log.i(this.getClass().getName(), "Dependency Injection works fine...");
    }
}
