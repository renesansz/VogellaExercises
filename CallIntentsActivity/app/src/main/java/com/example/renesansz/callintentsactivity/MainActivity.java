package com.example.renesansz.callintentsactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.intents, R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void onClick(View v) {
        int position = spinner.getSelectedItemPosition();
        Intent i = null;

        switch (position) {
            case 0:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
                break;
            case 1:
                i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+49)123456789"));
                break;
            case 2:
                i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+49)123456789"));
                break;
            case 3:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
                break;
            case 4:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q=query"));
                break;
            case 5:
                i = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 6:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                break;
            case 7:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/1"));
                break;
        }

        if (i != null) {
            startActivity(i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            String result = data.toUri(0);
            Toast.makeText(this, result, Toast.LENGTH_SHORT);
        }
    }
}
