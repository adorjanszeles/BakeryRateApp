package hu.dodotech.bakeryrateapp.view.bakerycreat;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.common.RatingHelper;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.presenter.BakeryCreatePresenter;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListFragment;

public class BakeryCreateFragment extends Fragment implements BakeryCreateScreen {
    private EditText name;
    private EditText address;
    private EditText details;
    private EditText rate;

    @Inject
    protected BakeryCreatePresenter bakeryCreatePresenter;

    public BakeryCreateFragment() {
        BakeryApp.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        bakeryCreatePresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        bakeryCreatePresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.bakery_create, container, false);
        name = (EditText)result.findViewById(R.id.name);
        address = (EditText)result.findViewById(R.id.address);
        details = (EditText)result.findViewById(R.id.details);
        rate = (EditText)result.findViewById(R.id.rate);
        Button save = (Button) result.findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBakery();
            }
        });
        return result;
    }

    private void createBakery() {
        Bakery bakery = new Bakery();
        if("".equals(details.getText().toString())) {
            bakeryCreatePresenter.showError("Nem adtál meg részletes leírást!");
            return;
        }
        if("".equals(address.getText().toString())) {
            bakeryCreatePresenter.showError("Nem adtál meg vásárlási címet!");
            return;
        }
        if("".equals(name.getText().toString())) {
            bakeryCreatePresenter.showError("Nem adtál meg termék nevet!");
            return;
        }
        String rateNum = rate.getText().toString();
        if("".equals(rateNum) || rateNum == null) {
            bakeryCreatePresenter.showError("Nem adtál meg értékelést!");
            return;
        }
        bakery.setDetails(details.getText().toString());
        bakery.setAddress(address.getText().toString());
        bakery.setName(name.getText().toString());
        bakery.setBakeryImageResourceId(R.drawable.cocoa);
        RatingHelper.calculatNewRating(bakery, Integer.parseInt(rateNum));
        bakeryCreatePresenter.addBakery(bakery);
    }

    @Override
    public void showAllBakery() {
        Fragment fragment = new BakeryListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        getActivity().setTitle("Minden pékáru");
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
