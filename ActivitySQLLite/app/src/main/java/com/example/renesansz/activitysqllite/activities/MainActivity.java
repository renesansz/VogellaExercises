package com.example.renesansz.activitysqllite.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.renesansz.activitysqllite.R;
import com.example.renesansz.activitysqllite.database.CommentDataSource;
import com.example.renesansz.activitysqllite.models.Comment;

import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {

    private CommentDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new CommentDataSource(this);
        dataSource.open();

        List<Comment> values = dataSource.getAllComments();

        // Use the SimpleCursorAdapter to show the elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this, R.layout.activity_main, values);
        setListAdapter(adapter);
    }

    public void onClick(View v) {
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();

        Comment comment = null;

        switch (v.getId()) {
            case R.id.add:
                String[] comments = new String[] { "Cool", "Very nice", "Hat it" };
                int nextInt = new Random().nextInt(3);

                // Save the new comment to the database
                comment = dataSource.createComment(comments[nextInt]);

                adapter.add(comment);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    dataSource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}
