package hu.dodotech.bakeryrateapp.view.search;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.common.SearchItem;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListFragment;

public class BakerySearchFragment extends Fragment {

    public BakerySearchFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.bakery_search, container, false);
        final EditText name = (EditText)result.findViewById(R.id.searchName);
        final EditText address = (EditText)result.findViewById(R.id.searchAddress);
        final EditText rate = (EditText)result.findViewById(R.id.searchRate);
        final Button searchButton = (Button) result.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchItem searchItem = new SearchItem();
                searchItem.setAddress(address.getText().toString());
                searchItem.setName(name.getText().toString());
                if (!"".equals(rate.getText().toString())) {
                    searchItem.setRate(Double.parseDouble(rate.getText().toString()));
                }
                queryResultList(searchItem);
            }
        });
        return result;
    }

    private void queryResultList(SearchItem item) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("searchItem", item);
        Fragment fragment = new BakeryListFragment();
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        getActivity().setTitle("Keresés eredménye");
    }
}
