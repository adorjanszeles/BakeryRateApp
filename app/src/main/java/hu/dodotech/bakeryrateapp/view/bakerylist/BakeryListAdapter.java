package hu.dodotech.bakeryrateapp.view.bakerylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hu.dodotech.bakeryrateapp.R;
import hu.dodotech.bakeryrateapp.model.bakery.Bakery;

public class BakeryListAdapter extends BaseAdapter {
    private Context context;
    private List<Bakery> bakeryList;
    private static LayoutInflater inflater;

    public BakeryListAdapter(Context context, List<Bakery> bakeryList) {
        this.context = context;
        this.bakeryList = bakeryList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bakeryList.size();
    }

    @Override
    public Object getItem(int position) {
        return bakeryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bakeryList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if(vi == null) {
            vi = inflater.inflate(R.layout.list_item, null);
        }

        TextView name = (TextView) vi.findViewById(R.id.bakeryName);
        ImageView rateView = (ImageView) vi.findViewById(R.id.rateView);
        ImageView bakeryView = (ImageView) vi.findViewById(R.id.bakeryView);
        Bakery currentBakery = bakeryList.get(position);

        name.setText(currentBakery.getName());
        bakeryView.setImageResource(currentBakery.getBakeryImageResourceId());
        rateView.setImageResource(currentBakery.getRateImageResourceId());
        return vi;
    }
}
