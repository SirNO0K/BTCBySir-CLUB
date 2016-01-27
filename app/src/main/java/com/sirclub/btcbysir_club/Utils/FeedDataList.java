package com.sirclub.btcbysir_club.Utils;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by arin on 1/22/16.
 */
public class FeedDataList {
    private static String result;
    private static RequestBody formBody;

    public static String FeedData(String _url, String[] bodyTitle, String[] bodyValue) {
        try {

            if (bodyTitle != null) {
                for (int i = 0; i < bodyTitle.length; i++) {
                    formBody = new FormBody.Builder()
                            .add(bodyTitle[i],bodyValue[i])
                            .build();
                }
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(_url)
                    .build();

            Response response = client.newCall(request).execute();

            result = response.body().string();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


}
