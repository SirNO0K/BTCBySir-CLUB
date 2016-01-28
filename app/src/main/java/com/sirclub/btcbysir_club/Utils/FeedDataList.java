package com.sirclub.btcbysir_club.Utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arin on 1/22/16.
 */
public class FeedDataList {

    public static String feedGetData(String _url) {
        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(_url)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            return "" + response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
