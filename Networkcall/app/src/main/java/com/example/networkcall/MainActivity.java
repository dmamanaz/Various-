package com.example.networkcall;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView title, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        url = findViewById(R.id.url);
        new ExecuteNetworkCall().execute();
    }

    //   https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=5&printType=books


    public String convertIS(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = buffer.readLine()) != null) {
            builder.append(line + "\n");
        }
        return builder.toString();
    }

    public void getDataFromString(String parseIS) throws JSONException {

    }
    // create a class to extend Asynctask
    // inner class - sibling of main activity class
    class ExecuteNetworkCall extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {

            String BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
            String PARAM_Q = "q";
            String PARAM_MAX_RESULTS = "maxResults";
            String PARAM_PRINT_TYPE = "printType";
            Uri baseUri = Uri.parse(BASE_URL).buildUpon()
                    .appendQueryParameter(PARAM_Q, "pride+prejudice")
                    .appendQueryParameter(PARAM_PRINT_TYPE, "books")
                    .appendQueryParameter(PARAM_MAX_RESULTS, "5")
                    .build();
            URL booksUrl = null;
            String parseResponse = null;
            try {
                booksUrl = new URL(baseUri.toString());

                HttpURLConnection connection = (HttpURLConnection) booksUrl.openConnection();
                connection.setConnectTimeout(20000);
                connection.setReadTimeout(20000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();
                parseResponse = convertIS(connection.getInputStream());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return parseResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject response = null;
            try {
                response = new JSONObject(s);

                JSONArray items = response.getJSONArray("items");
                JSONObject itemDetail = items.getJSONObject(0);
                JSONObject volumeInfo = itemDetail.getJSONObject("volumeInfo");
                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                title.setText(volumeInfo.getString("title"));
                url.setText(imageLinks.getString("thumbnail"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}