package com.example.renesansz.multipanefragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnItemSelectedListener {

    SelectionStateFragment stateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);

        if (this.findViewById(R.id.fragment_container) != null) {
            MyListFragment listFragment = new MyListFragment();
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, listFragment)
                .commit();
        }
    }

    @Override
    public void onRssItemSelected(String link) {

        if (stateFragment != null) {
            stateFragment.lastSelection = link;
        }

        if (getResources().getBoolean(R.bool.twoPaneMode)) {
            DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            fragment.setText(link);
        } else {
            DetailFragment newFragment = new DetailFragment();
            Bundle args = new Bundle();

            args.putString(DetailFragment.EXTRA_URL, link);

            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }
}
