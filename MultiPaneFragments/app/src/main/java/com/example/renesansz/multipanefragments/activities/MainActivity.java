package com.example.renesansz.multipanefragments.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.renesansz.multipanefragments.fragments.DetailFragment;
import com.example.renesansz.multipanefragments.fragments.MyListFragment;
import com.example.renesansz.multipanefragments.R;
import com.example.renesansz.multipanefragments.fragments.SelectionStateFragment;
import com.example.renesansz.rssfeedlibrary.RssItem;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnItemSelectedListener, ActionMode.Callback {

    SelectionStateFragment stateFragment;

    private static String LOG = "test";
    private RssItem selectedRssItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG, "On Create");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(LOG, "On Creating Options Menu");

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);

        tb.inflateMenu(R.menu.main_menu);
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return onOptionsItemSelected(item);
            }
        });

//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                Toast.makeText(this, "Refresh Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settngs:
                Intent intent = new Intent(this, PreferenceActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
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
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

            intent.putExtra(Intent.EXTRA_TEXT, link);

            startActivity(intent);
//            DetailFragment newFragment = new DetailFragment();
//            Bundle args = new Bundle();
//
//            args.putString(DetailFragment.EXTRA_URL, link);
//
//            newFragment.setArguments(args);
//
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            transaction.replace(R.id.fragment_container, newFragment);
//            transaction.addToBackStack(null);
//            transaction.commit();
        }
    }

    @Override
    public void goToActionMode(RssItem item) {
        this.selectedRssItem = item;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater menuInflater = mode.getMenuInflater();
        menuInflater.inflate(R.menu.actionmode, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_TEXT, "I found this interesting link" + selectedRssItem.getLink());
        intent.setType("text/plain");

        startActivity(intent);

        mode.finish();

        selectedRssItem = null;

        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
    }
}
