package hu.dodotech.bakeryrateapp.view.bakerylist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.dodotech.bakeryrateapp.BakeryApp;
import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;
import hu.dodotech.bakeryrateapp.model.helper.SearchItem;
import hu.dodotech.bakeryrateapp.presenter.BakeryListPresenter;
import hu.dodotech.bakeryrateapp.view.bakerydetails.BakeryDetailsFragment;

public class BakeryListFragment extends Fragment implements BakeryListScreen {
    private ListView listView;
    private List<Bakery> bakeryList;

    @Inject
    protected BakeryListPresenter bakeryListPresenter;

    public BakeryListFragment() {
        BakeryApp.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        bakeryListPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        bakeryListPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View result = inflater.inflate(R.layout.bakery_list, container, false);
        initializeBakeryListAndAdapter();
        initializeListView(result);
        fillBakeryList();
        return result;
    }

    private void initializeBakeryListAndAdapter() {
        bakeryList = new ArrayList<>();
    }

    private void initializeListView(View result) {
        listView = (ListView)result.findViewById(R.id.bakeryList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                inflateDetailFragment(position);
            }
        });
    }

    private void fillBakeryList() {
        if(getArguments() != null) {
            SearchItem item = (SearchItem)getArguments().getSerializable("searchItem");
            bakeryListPresenter.queryBakeryItems(item);
        } else {
            bakeryListPresenter.getAllBakeryItems();
        }
    }

    private void inflateDetailFragment(int position) {
        Fragment fragment = new BakeryDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bakery", bakeryList.get(position));
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        getActivity().setTitle("Pékáru részletező");
    }

    @Override
    public void showBakeryList(List<Bakery> bakeries) {
        bakeryList = bakeries;
        listView.setAdapter(new BakeryListAdapter(getContext(), bakeryList));
    }
}
