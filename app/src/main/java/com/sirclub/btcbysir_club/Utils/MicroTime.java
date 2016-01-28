package com.sirclub.btcbysir_club.Utils;

/**
 * Created by SaNO0K on 28/01/2016.
 */
public class MicroTime {
    public static boolean useNative = false;

    static {
        try {
            System.loadLibrary("MicroTime");
            useNative = true;
        } catch (java.lang.UnsatisfiedLinkError e) {
            System.out.println("Using Java Time function in MicroTime");
            useNative = false;
        }
    }

    public static double getTime() {
        if (useNative) {
            return getMicroTime();
        } else {
            return System.currentTimeMillis() / 1000.;
        }
    }

    public static native double getMicroTime();
}
