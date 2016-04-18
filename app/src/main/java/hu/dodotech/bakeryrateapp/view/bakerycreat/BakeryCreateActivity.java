package hu.dodotech.bakeryrateapp.view.bakerycreat;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.presenter.BakeryCreatePresenter;

public class BakeryCreateActivity extends Activity {
    @Inject
    protected BakeryCreatePresenter bakeryCreatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bakery_create);
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
