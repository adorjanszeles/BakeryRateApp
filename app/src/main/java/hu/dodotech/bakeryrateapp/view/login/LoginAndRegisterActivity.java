package hu.dodotech.bakeryrateapp.view.login;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.presenter.LoginAndRegisterPresenter;

public class LoginAndRegisterActivity extends Activity {
    @Inject
    protected LoginAndRegisterPresenter loginAndRegisterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_and_register);
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
