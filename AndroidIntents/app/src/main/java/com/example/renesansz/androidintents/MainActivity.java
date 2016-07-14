package com.example.renesansz.androidintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Constant to determine which sub-activity returns
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText text = (EditText)findViewById(R.id.inputForIntent);
        String value = text.getText().toString();

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("testValue", value);

        startActivityForResult(i, REQUEST_CODE);
    }

    public void shareData(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);

        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is awesome share sheet!!");

        startActivity(sharingIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey")) {
                String result = data.getExtras().getString("returnKey");
                if (result != null && result.length() > 0) {
                    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
