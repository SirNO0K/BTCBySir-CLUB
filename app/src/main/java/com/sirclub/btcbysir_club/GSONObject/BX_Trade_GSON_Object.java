package com.sirclub.btcbysir_club.GSONObject;

import java.util.List;

/**
 * Created by SaNO0K on 28/01/2016.
 */
public class BX_Trade_GSON_Object {

    /**
     * trade_id : 167835
     * rate : 13300.00000000
     * amount : 0.00100000
     * trade_date : 2016-01-27 17:35:50
     * order_id : 3123284
     * trade_type : sell
     * seconds : 2505
     */

    private List<TradesEntity> trades;
    /**
     * order_id : 3123484
     * rate : 13480.00000000
     * amount : 2.00000000
     * date_added : 2016-01-27 18:12:36
     * order_type : sell
     * display_vol1 : 26,960.00 THB
     * display_vol2 : 2.00000000 BTC
     */

    private List<LowaskEntity> lowask;
    /**
     * order_id : 3123485
     * rate : 13302
     * amount : 0.32298768
     * date_added : 2016-01-27 18:12:59
     * order_type : buy
     * display_vol1 : 4,296.38 THB
     * display_vol2 : 0.32298768 BTC
     */

    private List<HighbidEntity> highbid;

    public void setTrades(List<TradesEntity> trades) {
        this.trades = trades;
    }

    public void setLowask(List<LowaskEntity> lowask) {
        this.lowask = lowask;
    }

    public void setHighbid(List<HighbidEntity> highbid) {
        this.highbid = highbid;
    }

    public List<TradesEntity> getTrades() {
        return trades;
    }

    public List<LowaskEntity> getLowask() {
        return lowask;
    }

    public List<HighbidEntity> getHighbid() {
        return highbid;
    }

    public static class TradesEntity {
        private String trade_id;
        private String rate;
        private String amount;
        private String trade_date;
        private String order_id;
        private String trade_type;
        private int seconds;

        public void setTrade_id(String trade_id) {
            this.trade_id = trade_id;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public void setTrade_date(String trade_date) {
            this.trade_date = trade_date;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public String getTrade_id() {
            return trade_id;
        }

        public String getRate() {
            return rate;
        }

        public String getAmount() {
            return amount;
        }

        public String getTrade_date() {
            return trade_date;
        }

        public String getOrder_id() {
            return order_id;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public int getSeconds() {
            return seconds;
        }
    }

    public static class LowaskEntity {
        private String order_id;
        private String rate;
        private String amount;
        private String date_added;
        private String order_type;
        private String display_vol1;
        private String display_vol2;

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public void setDisplay_vol1(String display_vol1) {
            this.display_vol1 = display_vol1;
        }

        public void setDisplay_vol2(String display_vol2) {
            this.display_vol2 = display_vol2;
        }

        public String getOrder_id() {
            return order_id;
        }

        public String getRate() {
            return rate;
        }

        public String getAmount() {
            return amount;
        }

        public String getDate_added() {
            return date_added;
        }

        public String getOrder_type() {
            return order_type;
        }

        public String getDisplay_vol1() {
            return display_vol1;
        }

        public String getDisplay_vol2() {
            return display_vol2;
        }
    }

    public static class HighbidEntity {
        private String order_id;
        private int rate;
        private String amount;
        private String date_added;
        private String order_type;
        private String display_vol1;
        private String display_vol2;

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public void setDisplay_vol1(String display_vol1) {
            this.display_vol1 = display_vol1;
        }

        public void setDisplay_vol2(String display_vol2) {
            this.display_vol2 = display_vol2;
        }

        public String getOrder_id() {
            return order_id;
        }

        public int getRate() {
            return rate;
        }

        public String getAmount() {
            return amount;
        }

        public String getDate_added() {
            return date_added;
        }

        public String getOrder_type() {
            return order_type;
        }

        public String getDisplay_vol1() {
            return display_vol1;
        }

        public String getDisplay_vol2() {
            return display_vol2;
        }
    }
}
