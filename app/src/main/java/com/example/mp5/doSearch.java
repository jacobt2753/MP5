package com.example.mp5;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.view.ViewGroup.LayoutParams;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import androidx.appcompat.app.AppCompatActivity;
public abstract class doSearch extends AppCompatActivity {
    public class Searchdo extends AsyncTask<Void, Void, String> {
        Response response;
        private Exception exception;
        protected void onPreExecute() {

        }
        protected String doInBackground(Void... urls) {
            try {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://microsoft-azure-bing-news-search-v1.p.rapidapi.com/search?q=wow")
                        .get()
                        .addHeader("x-rapidapi-host", "microsoft-azure-bing-news-search-v1.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "f572830147msh03231405d4e5c5bp13eef3jsn04670819f50a")
                        .build();

                Response response = client.newCall(request).execute();
            }
            catch (Exception e) {
                Log.e("Error", exception.getMessage(), exception);
                return null;
            }
            return response.toString();
        }
        protected void onPostExecute(String response) {
            if (response == null) {
                response = "An error has occurred.";
            }
            Log.i("Feed", response);
        }
    }
}
