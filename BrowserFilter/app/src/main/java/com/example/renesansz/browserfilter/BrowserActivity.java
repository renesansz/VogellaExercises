package com.example.renesansz.browserfilter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BrowserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_browser);

        Intent intent = getIntent();

        TextView tv = (TextView) findViewById(R.id.textView);

        String action = intent.getAction();

        if ( ! action.equals(Intent.ACTION_VIEW)) {
            throw new RuntimeException("Should not happen");
        }

        Uri data = intent.getData();
        URL url;

        try {
            url = new URL(data.getScheme(), data.getHost(), data.getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";

            while ((line = br.readLine()) != null) {
                tv.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
