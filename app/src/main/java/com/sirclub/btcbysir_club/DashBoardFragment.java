package com.sirclub.btcbysir_club;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sirclub.btcbysir_club.AVERAGE.AverageAdapter;
import com.sirclub.btcbysir_club.Utils.CommonUtil;
import com.sirclub.btcbysir_club.Utils.FeedDataList;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    private View mView;
    private ListView mAvgPage;
    private Fragment mContent;
    private Avg_ReLoad mAvg_ReLoad;
    private String[] mAvgUrl;


    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (CommonUtil.DashBoard_Stage == false) {
            mView = inflater.inflate(R.layout.fragment_dash_board, container, false);
            bindWidgets();
            new feedAVGData().execute(mAvgUrl[0], mAvgUrl[1]);
            CommonUtil.DashBoard_Stage = true;
        }

        return mView;
    }

    private void bindWidgets() {
        mAvgPage = (ListView) mView.findViewById(R.id.AVG_Page);
        mAvgUrl = getResources().getStringArray(R.array.AVG_URL);
        mAvg_ReLoad = new Avg_ReLoad(5000, 1000);
    }

    private class feedAVGData extends AsyncTask<String, Void, ArrayList<Object>> {

        ArrayList<Object> returnResult = new ArrayList<>();
        final Calendar mTime = Calendar.getInstance();

        @Override
        protected ArrayList<Object> doInBackground(String... params) {

            try {
                returnResult.add(0,CommonUtil.dateFormat.format(mTime.getTime()) + " " + CommonUtil.timeFormat.format(mTime.getTime()));
                for (int i = 0; i < params.length; i++) {

                    Double result = new JSONObject(FeedDataList.FeedData(params[i], null, null)).getDouble("last");
                    returnResult.add(i+1,result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return returnResult;
        }

        @Override
        protected void onPostExecute(ArrayList<Object> jsonObject) {
            super.onPostExecute(jsonObject);

            mAvgPage.setAdapter(new AverageAdapter(getActivity(), jsonObject));
            mAvg_ReLoad.start();
        }
    }

    public class Avg_ReLoad extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public Avg_ReLoad(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            new feedAVGData().execute(mAvgUrl[0],mAvgUrl[1]);
        }
    }

}
