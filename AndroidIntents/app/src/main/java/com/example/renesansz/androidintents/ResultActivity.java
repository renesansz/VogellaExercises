package com.example.renesansz.androidintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    public void finish() {
        Intent intent = new Intent();
        EditText editText = (EditText)findViewById(R.id.returnValue);

        String string = editText.getText().toString();
        intent.putExtra("returnKey", string);

        setResult(RESULT_OK, intent);

        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        String inputString = extras .getString("testValue");
        TextView tv = (TextView)findViewById(R.id.displayIntentExtra);
        tv.setText(inputString);
    }

}
