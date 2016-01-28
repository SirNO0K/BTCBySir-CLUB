package com.sirclub.btcbysir_club.Utils;

import java.security.MessageDigest;

/**
 * Created by SaNO0K on 28/01/2016.
 */
public class HashData {

    public static String GetData(String api_key, String api_secret, String nonce) {
        String Key = api_key + nonce + api_secret;
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Key.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
