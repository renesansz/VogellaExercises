package com.example.renesansz.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private boolean isConnected;
    private ImageView indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isConnected = false;
        indicator = (ImageView)findViewById(R.id.indicator);

        // Set on click listener for radio buttons
        final RadioGroup group1 = (RadioGroup)findViewById(R.id.orientation);

        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.horizontal:
                        group.setOrientation(LinearLayout.HORIZONTAL);
                        break;
                    case R.id.vertical:
                        group.setOrientation(LinearLayout.VERTICAL);
                        break;
                }
            }
        });
    }

    public void onClick(View v) {
        if ( ! isConnected) {
            indicator.setImageResource(R.drawable.ic_phonelink_ring_black_24dp);
            isConnected = true;
        } else {
            indicator.setImageResource(R.drawable.ic_portable_wifi_off_black_24dp);
            isConnected = false;
        }
    }

}
