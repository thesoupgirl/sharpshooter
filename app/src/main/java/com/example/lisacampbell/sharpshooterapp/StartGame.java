package com.example.lisacampbell.sharpshooterapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.gc.materialdesign.views.ButtonRectangle;
import android.app.FragmentTransaction;


public class StartGame extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public SubmitCallbackListener activity;
    private ButtonRectangle startBtn; //camera button
    private TextView label;

    // TODO: Rename and change types and number of parameters
//    public static StartGame newInstance(String param1, String param2) {
//        StartGame fragment = new StartGame();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    public static StartGame newInstance(SubmitCallbackListener activity) {
        StartGame f = new StartGame();

        f.activity = activity;
        return f;
    }

    public StartGame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_start_game, container, false);
        startBtn = (ButtonRectangle) v.findViewById(R.id.start);
        label = (TextView) v.findViewById(R.id.label);
       // label.setGravity(Gravity.CENTER_HORIZONTAL);
        //v.findViewById(R.id.start).setOnClickListener();
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment frag = new BeforePhoto();


                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.start_game, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        //onSubmit(v);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onClick(View v) {
//        //this.activity.onSubmit();
//    }
    public void onSubmit(View v) {
        this.activity.onSubmit();
    }


}
