package hu.dodotech.bakeryrateapp.view.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.common.FragmentType;
import hu.dodotech.bakeryrateapp.model.helper.NavigationItem;
import hu.dodotech.bakeryrateapp.view.bakerycreat.BakeryCreateFragment;
import hu.dodotech.bakeryrateapp.view.bakerylist.BakeryListFragment;
import hu.dodotech.bakeryrateapp.view.menu.DrawerListAdapter;
import hu.dodotech.bakeryrateapp.view.search.BakerySearchFragment;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private List<NavigationItem> mNavItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initializeMenu();
        inflateFragment(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void initializeMenu() {
        mNavItems = new ArrayList<>();
        mNavItems.add(new NavigationItem("Minden pékáru", R.drawable.ic_explore_black_24dp, FragmentType.ALL));
        mNavItems.add(new NavigationItem("Keresés", R.drawable.ic_search_black_24dp, FragmentType.SEARCH));
        mNavItems.add(new NavigationItem("Új pékárú", R.drawable.ic_add_black_24dp, FragmentType.ADD_NEW));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        ListView mDrawerList = (ListView) findViewById(R.id.navList);

        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                inflateFragment(position);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void inflateFragment(int position) {
        Fragment fragment = null;
        switch(mNavItems.get(position).getType()) {
            case ALL:
                fragment = new BakeryListFragment();
                break;
            case ADD_NEW:
                fragment = new BakeryCreateFragment();
                break;
            case SEARCH:
                fragment = new BakerySearchFragment();
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        setTitle(mNavItems.get(position).getTitle());
        mDrawerLayout.closeDrawer(mDrawerPane);
    }
}
