package com.example.lisacampbell.sharpshooterapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.gc.materialdesign.views.ButtonRectangle;


public class Ready extends Fragment {

    public TextView almostReady;
    public TextView readyInfo;
    public ButtonRectangle readyBtn;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ready.
     */
    // TODO: Rename and change types and number of parameters
    public static Ready newInstance(String param1, String param2) {
        Ready fragment = new Ready();
        Bundle args = new Bundle();
        return fragment;
    }

    public Ready() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_ready, container, false);
        readyBtn = (ButtonRectangle) v.findViewById(R.id.readyBtn);
        readyInfo = (TextView) v.findViewById(R.id.almostReady);
        // label.setGravity(Gravity.CENTER_HORIZONTAL);
        //v.findViewById(R.id.start).setOnClickListener();
        readyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //service.startGame();

                Fragment frag = new BeforePhoto();


                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.start_game, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }





}
