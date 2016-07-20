package com.example.renesansz.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] values = new String[] {
                "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu",
                "Windows 7", "Mac OSX", "Linux", "OS/2"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, values);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String item = (String) getListAdapter().getItem(position);

        Toast.makeText(this, item + " selected", Toast.LENGTH_SHORT).show();
    }
}
