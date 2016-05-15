package hu.dodotech.bakeryrateapp.view.bakerydetails;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.common.RatingHelper;
import hu.dodotech.bakeryrateapp.model.Bakery;
import hu.dodotech.bakeryrateapp.presenter.BakeryDetailsPresenter;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListFragment;

public class BakeryDetailsFragment extends Fragment implements BakeryDetailsScreen {
    private Bakery bakery;
    @Inject
    protected BakeryDetailsPresenter bakeryDetailsPresenter;

    public BakeryDetailsFragment() {
        BakeryApp.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        bakeryDetailsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        bakeryDetailsPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.bakery_details, container, false);
        EditText name = (EditText)result.findViewById(R.id.detailsName);
        EditText address = (EditText)result.findViewById(R.id.detailsAddress);
        EditText details = (EditText)result.findViewById(R.id.detailsDetails);
        ImageView rateView = (ImageView)result.findViewById(R.id.ratingView);
        ImageView bakeryView = (ImageView)result.findViewById(R.id.detailsImage);
        final EditText rateNumber = (EditText)result.findViewById(R.id.detailsRating);
        Button rate = (Button)result.findViewById(R.id.rateButton);
        Button delete = (Button)result.findViewById(R.id.deleteButton);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rate = rateNumber.getText().toString();
                if(rate == null || "".equals(rate)) {
                    bakeryDetailsPresenter.showError("Nem adtál meg értékelési számot!");
                } else {
                    modifyBakeryRating(Integer.parseInt(rate));
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bakeryDetailsPresenter.deleteBakery(bakery);
            }
        });
        bakery = (Bakery)this.getArguments().getSerializable("bakery");
        name.setText(bakery.getName());
        address.setText(bakery.getAddress());
        details.setText(bakery.getDetails());
        rateView.setImageResource(bakery.getRateImageResourceId());
        bakeryView.setImageResource(bakery.getBakeryImageResourceId());
        return result;
    }

    private void modifyBakeryRating(int rate) {
        RatingHelper.calculatNewRating(bakery, rate);
        bakeryDetailsPresenter.modifyBakeryRatings(bakery);
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
