package com.android.mercariinterviewapp.home.mvp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.android.mercariinterviewapp.data.Item;
import com.android.mercariinterviewapp.data.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import timber.log.Timber;

/**
 * Created by AbhishekKejriwal on 7/12/2017.
 */

public class HomeInteractor {

    private Context context;
    public HomeInteractor(Context context) {
        this.context = context;
    }

    public String getJsonString() {
        String json;
        try {
            InputStream is = context.getAssets().open("all.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Timber.e(ex, ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public List<Item> getItemList() {
        Gson gson = new Gson();
        Response response = gson.fromJson(getJsonString(), Response.class);
        return response.data;
    }
}
