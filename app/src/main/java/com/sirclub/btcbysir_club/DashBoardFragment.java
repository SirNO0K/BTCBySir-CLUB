package com.sirclub.btcbysir_club;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.sirclub.btcbysir_club.AVERAGE.AverageAdapter;
import com.sirclub.btcbysir_club.GSONObject.Average_GSON_Object;
import com.sirclub.btcbysir_club.Utils.CommonUtil;
import com.sirclub.btcbysir_club.Utils.ServerHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


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


        final Calendar mTime = Calendar.getInstance();

        @Override
        protected ArrayList<Object> doInBackground(String... params) {


            ArrayList<Object> returnResult = new ArrayList<>();
            Gson gson = new Gson();

            returnResult.add(0, CommonUtil.dateFormat.format(mTime.getTime()) + " " + CommonUtil.timeFormat.format(mTime.getTime()));

            for (int i = 0; i < params.length; i++) {
                String result = ServerHandler.feedGetData(params[i]);
                List<Average_GSON_Object> enums = Arrays.asList(gson.fromJson(result,Average_GSON_Object.class));
                returnResult.add(i+1,enums.get(0).getLast());
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
            new feedAVGData().execute(mAvgUrl[0], mAvgUrl[1]);
        }
    }

}
