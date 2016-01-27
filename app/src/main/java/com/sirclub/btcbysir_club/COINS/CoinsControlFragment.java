package com.sirclub.btcbysir_club.COINS;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sirclub.btcbysir_club.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoinsControlFragment extends Fragment {


    public CoinsControlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coins_control, container, false);
    }

}
