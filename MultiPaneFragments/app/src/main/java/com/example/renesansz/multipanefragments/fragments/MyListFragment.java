package com.example.renesansz.multipanefragments.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renesansz.multipanefragments.R;
import com.example.renesansz.rssfeedlibrary.RssItem;

public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= null;
        v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.rowlayout, parent, false);
        return new RecyclerView.ViewHolder(v);
    }

    public interface OnItemSelectedListener {
        void onRssItemSelected(String link);
        void goToActionMode(RssItem item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Renesansz", "On Attach!!");
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail(String uri) {
        Log.d("Renesansz", "updateDetail() " + uri);
        String newTime = String.valueOf(System.currentTimeMillis());
        listener.onRssItemSelected(newTime);
    }

    public void goToActionMode(RssItem item) {
        listener.goToActionMode(item);
    }

}
