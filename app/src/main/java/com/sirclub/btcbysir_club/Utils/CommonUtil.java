package com.sirclub.btcbysir_club.Utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by arin on 1/22/16.
 */
public class CommonUtil {

    public static DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static Integer mCount = 0;

    public static Boolean DashBoard_Stage = false;

    public static String mTHB = "";
    public static String mUSD = "";

}
