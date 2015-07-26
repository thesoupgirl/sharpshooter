package com.example.lisacampbell.sharpshooterapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.gc.materialdesign.views.ButtonRectangle;
import android.app.FragmentTransaction;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Loser extends Fragment {

    public SubmitCallbackListener activity;
    private ButtonRectangle endBtn;
    private TextView text;
    private TextView secondText;



    public static Loser newInstance(SubmitCallbackListener activity) {
        Loser fragment = new Loser();
        fragment.activity = activity;
        return fragment;
    }

    public Loser() {
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
        View v = inflater.inflate(R.layout.fragment_loser, container, false);
        endBtn = (ButtonRectangle) v.findViewById(R.id.endgame);
        text = (TextView) v.findViewById(R.id.labely);
        secondText = (TextView) v.findViewById(R.id.labelit);

        endBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //service.startGame();

                Fragment frag = new FirstLoginActivityFragment();


                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.lost_game, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }



}

