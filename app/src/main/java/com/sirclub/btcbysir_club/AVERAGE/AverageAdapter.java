package com.sirclub.btcbysir_club.AVERAGE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sirclub.btcbysir_club.R;

/**
 * Created by SaNO0K on 26/01/2016.
 */
public class AverageAdapter extends BaseAdapter {

    private final String mFeedData;
    public Context mContext;
    public LayoutInflater mInflater;
    private ViewHolder holder;
    String mDateTime;

    public AverageAdapter(Context context, String feedDataList) {
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

            convertView.setTag(holder);

        } else {
            //ReBind Widget
            holder = (ViewHolder) convertView.getTag();
        }

        holder.AVG_DateTime.setText(mFeedData);

        return convertView;
    }

    public class ViewHolder {
        TextView AVG_DateTime;
        TextView AVG_RateTHB;
        TextView AVG_Rate_USD;
    }
}
