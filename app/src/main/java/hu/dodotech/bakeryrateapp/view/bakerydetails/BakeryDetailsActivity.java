package hu.dodotech.bakeryrateapp.view.bakerydetails;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.presenter.BakeryDetailsPresenter;

public class BakeryDetailsActivity extends Activity {
    @Inject
    protected BakeryDetailsPresenter bakeryDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bakery_details);
        BakeryApp.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
