package com.example.renesansz.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    private class ViewHolder {
        public TextView text;
        public ImageView image;
    }

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.rowlayout, parent, false);

            // Configure the view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
            rowView.setTag(viewHolder);
        }

        // Fill data
        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        // Change font for Windows &  iPhone
        String s = values[position];

        viewHolder.text.setText(s);

        if (s.startsWith("Windows") || s.startsWith("iPhone") || s.startsWith("Solaris")) {
            viewHolder.image.setImageResource(R.drawable.no);
        } else {
            viewHolder.image.setImageResource(R.drawable.ok);
        }

        return rowView;
    }
}
