package com.example.renesansz.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<Model> adapter = new InteractiveArrayAdapter(this, getModel());
    }

    public List<Model> getModel() {
        List<Model> list = new ArrayList<Model>();
        list.add(get("Linux"));
        list.add(get("Windows7"));
        list.add(get("Suse"));
        list.add(get("Eclipse"));
        list.add(get("Ubuntu"));
        list.add(get("Solaris"));
        list.add(get("Android"));
        list.add(get("iPhone"));

        // Initially select one of the items
        list.get(1).setSelected(true);

        return list;
    }

    private Model get(String s) {
        return new Model(s);
    }

    /*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] values = new String[] {
                "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu",
                "Windows 7", "Mac OSX", "Linux", "OS/2"
        };

//         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, values);

        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
        
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String item = (String) getListAdapter().getItem(position);

        Toast.makeText(this, item + " selected", Toast.LENGTH_SHORT).show();
    }*/
}
