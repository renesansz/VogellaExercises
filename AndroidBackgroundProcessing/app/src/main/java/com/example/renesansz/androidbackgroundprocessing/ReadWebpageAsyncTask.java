package com.example.renesansz.androidbackgroundprocessing;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReadWebpageAsyncTask {

    private TextView textView;

    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(urls[0]).build();
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                return response.body().string();
            }

            return "Download failed";
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }
    }

    public void onClick(View view) {
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[] { "http://www.vogella.com/index.html" });
    }

}
