package com.sirclub.btcbysir_club.AVERAGE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sirclub.btcbysir_club.R;
import com.sirclub.btcbysir_club.Utils.CommonUtil;

import java.util.ArrayList;

/**
 * Created by SaNO0K on 26/01/2016.
 */
public class AverageAdapter extends BaseAdapter {

    private final ArrayList<Object> mFeedData;
    public Context mContext;
    public LayoutInflater mInflater;
    private ViewHolder holder;
    private String Avg_THB;
    private String Avg_USD;
    private String Avg_Time;


    public AverageAdapter(Context context, ArrayList<Object> feedDataList) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mFeedData = feedDataList;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        holder = null;

        if (convertView == null) {
            //Load Layout
            convertView = mInflater.inflate(R.layout.average_list, null);
            holder = new ViewHolder();

            holder.AVG_DateTime = (TextView) convertView.findViewById(R.id.avg_DateTime);
            holder.AVG_Rate_THB = (TextView) convertView.findViewById(R.id.avg_THB);
            holder.AVG_Rate_USD = (TextView) convertView.findViewById(R.id.avg_USD);

            convertView.setTag(holder);

        } else {
            //ReBind Widget
            holder = (ViewHolder) convertView.getTag();

        }

        try {

            Avg_Time = mFeedData.get(0).toString();
            Avg_THB = "฿ : " + CommonUtil.decimalFormat.format(mFeedData.get(1));
            Avg_USD = "$ : " + CommonUtil.decimalFormat.format(mFeedData.get(2));

        } catch (Exception e) {
            e.printStackTrace();
        }

        SetData();

        return convertView;
    }

    private void SetData() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);

        holder.AVG_DateTime.setText(Avg_Time);
        if (!CommonUtil.mAVG_THB.equals(Avg_THB)) {
            holder.AVG_Rate_THB.startAnimation(anim);
            holder.AVG_Rate_THB.setText(Avg_THB);
            CommonUtil.mAVG_THB = Avg_THB;
        } else {
            holder.AVG_Rate_THB.setText(Avg_THB);
        }

        if (!CommonUtil.mAVG_USD.equals(Avg_USD)) {
            holder.AVG_Rate_USD.startAnimation(anim);
            holder.AVG_Rate_USD.setText(Avg_USD);
            CommonUtil.mAVG_USD = Avg_USD;
        } else {
            holder.AVG_Rate_USD.setText(Avg_USD);
        }
    }


    public class ViewHolder {
        TextView AVG_DateTime;
        TextView AVG_Rate_THB;
        TextView AVG_Rate_USD;
    }
}
