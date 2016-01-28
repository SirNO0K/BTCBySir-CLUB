package com.sirclub.btcbysir_club.GSONObject;

/**
 * Created by SaNO0K on 28/01/2016.
 */
public class Average_GSON_Object {

    /**
     * ask : 13858.41
     * bid : 13837.75
     * last : 13845.92
     * timestamp : Thu, 28 Jan 2016 09:20:50 -0000
     * volume_btc : 0.0
     * volume_percent : 0.0
     */

    private double ask;
    private double bid;
    private double last;

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getAsk() {
        return ask;
    }

    public double getBid() {
        return bid;
    }

    public double getLast() {
        return last;
    }
}
