package hu.dodotech.bakeryrateapp.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.common.NavigationItem;

public class DrawerListAdapter extends BaseAdapter {
    private Context context;
    private List<NavigationItem> navigationItems;

    public DrawerListAdapter(Context con, List<NavigationItem> items) {
        context = con;
        navigationItems = items;
    }

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navigationItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menu_item, null);
        }
        else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);

        titleView.setText(navigationItems.get(position).getTitle());
        iconView.setImageResource(navigationItems.get(position).getIcon());

        return view;
    }
}
