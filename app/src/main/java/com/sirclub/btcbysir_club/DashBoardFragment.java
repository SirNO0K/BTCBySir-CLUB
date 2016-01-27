package com.sirclub.btcbysir_club;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sirclub.btcbysir_club.AVERAGE.AverageAdapter;
import com.sirclub.btcbysir_club.Utils.CommonUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    private View mView;
    private ListView mAvgPage;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_dash_board, container, false);

        bindWidgets();
        new feedAVGData().execute();
        return mView;
    }

    private void bindWidgets() {
        mAvgPage = (ListView) mView.findViewById(R.id.AVG_Page);
        //mAvgPage.setAdapter(new AverageAdapter(getActivity()));
    }

    private class feedAVGData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String TTT = String.valueOf(CommonUtil.mCount++) ;

            return TTT;
        }

        @Override
        protected void onPostExecute(String jsonObject) {
            super.onPostExecute(jsonObject);

            mAvgPage.setAdapter(new AverageAdapter(getActivity(),jsonObject));
        }
    }


}
