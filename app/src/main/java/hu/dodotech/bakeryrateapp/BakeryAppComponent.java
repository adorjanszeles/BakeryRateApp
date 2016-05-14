package hu.dodotech.bakeryrateapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.dodotech.bakeryrateapp.interactor.BakeryCreateInteractor;
import hu.dodotech.bakeryrateapp.interactor.BakeryDetailsInteractor;
import hu.dodotech.bakeryrateapp.interactor.BakeryListInteractor;
import hu.dodotech.bakeryrateapp.interactor.InteractorModule;
import hu.dodotech.bakeryrateapp.model.live.ModelModule;
import hu.dodotech.bakeryrateapp.network.live.NetworkModule;
import hu.dodotech.bakeryrateapp.presenter.BakeryCreatePresenter;
import hu.dodotech.bakeryrateapp.presenter.BakeryDetailsPresenter;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;
import hu.dodotech.bakeryrateapp.view.UIModule;
import hu.dodotech.bakeryrateapp.view.bakerycreat.BakeryCreateFragment;
import hu.dodotech.bakeryrateapp.view.bakerydetails.BakeryDetailsFragment;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListFragment;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface BakeryAppComponent {
    void inject(BakeryListFragment bakeryListFragment);
    void inject(BakeryCreateFragment bakeryCreateFragment);
    void inject(BakeryDetailsFragment bakeryDetailsFragment);

    void inject(BakeryCreatePresenter bakeryCreatePresenter);
    void inject(BakeryDetailsPresenter bakeryDetailsPresenter);
    void inject(BakeryListPresenter bakeryListPresenter);

    void inject(BakeryCreateInteractor bakeryCreateInteractor);
    void inject(BakeryDetailsInteractor bakeryDetailsInteractor);
    void inject(BakeryListInteractor bakeryListInteractor);
}
