package hu.dodotech.bakeryrateapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.dodotech.bakeryrateapp.interactor.BakeryCreateInteractor;
import hu.dodotech.bakeryrateapp.interactor.BakeryDetailsInteractor;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.interactor.InteractorModule;
import hu.dodotech.bakeryrateapp.interactor.LoginAndRegisterInteractor;
import hu.dodotech.bakeryrateapp.model.MockModelModule;
import hu.dodotech.bakeryrateapp.presenter.BakeryCreatePresenter;
import hu.dodotech.bakeryrateapp.presenter.BakeryDetailsPresenter;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;
import hu.dodotech.bakeryrateapp.presenter.LoginAndRegisterPresenter;
import hu.dodotech.bakeryrateapp.view.UIModule;
import hu.dodotech.bakeryrateapp.view.bakerycreat.BakeryCreateActivity;
import hu.dodotech.bakeryrateapp.view.bakerydetails.BakeryDetailsActivity;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListActivity;
import hu.dodotech.bakeryrateapp.view.login.LoginAndRegisterActivity;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, MockModelModule.class})
public interface MockBakeryAppComponent {
    void inject(BakeryListActivity bakeryListActivity);
    void inject(BakeryCreateActivity bakeryCreateActivity);
    void inject(BakeryDetailsActivity bakeryDetailsActivity);
    void inject(LoginAndRegisterActivity loginAndRegisterActivity);

    void inject(BakeryCreatePresenter bakeryCreatePresenter);
    void inject(BakeryDetailsPresenter bakeryDetailsPresenter);
    void inject(BakeryListPresenter bakeryListPresenter);
    void inject(LoginAndRegisterPresenter loginAndRegisterPresenter);

    void inject(BakeryCreateInteractor bakeryCreateInteractor);
    void inject(BakeryDetailsInteractor bakeryDetailsInteractor);
    void inject(BakeryListInteractor bakeryListInteractor);
    void inject(LoginAndRegisterInteractor loginAndRegisterInteractor);
}
