package com.example.renesansz.listviewexpandable;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private final SparseArray<Group> groups;
    public LayoutInflater inflater;
    public Activity activity;

    public MyExpandableListAdapter(Activity act, SparseArray<Group> groups) {
        activity = act;
        this.groups = groups;
        inflater = act.getLayoutInflater();
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String children = (String) getChild(i, i1);

        TextView text = null;

        if (view == null) {
            view = inflater.inflate(R.layout.listrow_details, null);
        }

        text = (TextView) view.findViewById(R.id.textView1);
        text.setText(children);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, children, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.listrow_group, null);
        }

        Group group = (Group) getGroup(i);

        ((CheckedTextView) view).setText(group.string);
        ((CheckedTextView) view).setChecked(b);

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
