package com.example.newspaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ReadListView> {
    public CustomAdapter(Context context, int resource, List<ReadListView> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.item_listview, null);
        }
        ReadListView p = getItem(position);
        if (p != null) {
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvTitle.setText(p.title);
            TextView tvDate=view.findViewById(R.id.tvDate);
            tvDate.setText(p.date);

            ImageView imageView=view.findViewById(R.id.imageView);
            Picasso.with(getContext()).load(p.image).into(imageView);

        }
        return view;
    }

}
