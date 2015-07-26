package com.example.lisacampbell.sharpshooterapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.gc.materialdesign.views.ButtonRectangle;
import android.widget.TextView;
import android.view.Gravity;
import java.util.Random;


public class BeforePhoto extends Fragment{

    public SubmitCallbackListener activity;
    //public MyApp myApp;
    private ButtonRectangle cameraBtn; //camera button
    private TextView top;
    private TextView num;
    private TextView info;
    private TextView targetName;
    public String thingy;
    public int victimNum; //number that person can be killed by
    //private OnFragmentInteractionListener mListener;
//    private Drawable camera;


    public static BeforePhoto newInstance(SubmitCallbackListener activity) {
        BeforePhoto f = new BeforePhoto();

        f.activity = activity;
        return f;
    }

    public BeforePhoto() {
        // Required empty public constructor
    }

//    public static Drawable getDrawable(String name) {
//        Context context = MyApp.getContext();
//        int resourceId = context.getResources().getIdentifier(name, "drawable", MyApp.getContext().getPackageName());
//        return ContextCompat.getDrawable(context, resourceId);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        victimNum = randInt(11111,99998);
        thingy =  String.valueOf(victimNum);
        super.onCreate(savedInstanceState);
      //Drawable d = myApp.getDrawable("/Users/lisacampbell/SharpshooterApp/app/build/intermediates/res/debug/drawable-xhdpi/ic_camera_alt_black_18dp.png");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_before_photo, container, false);
        cameraBtn = (ButtonRectangle) v.findViewById(R.id.cameraBtn);
        top = (TextView) v.findViewById(R.id.frontalSelfie);
        num = (TextView) v.findViewById(R.id.numberID);
        info = (TextView) v.findViewById(R.id.target);
        targetName = (TextView) v.findViewById(R.id.targetName);

       num.setText((CharSequence) thingy);
       // top.setGravity(Gravity.CENTER_HORIZONTAL);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment frag = new WinScreen();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.screen, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        //onSubmit(v);
        return v;
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }


//    public interface OnFragmentInteractionListener {
//        public void onFragmentInteraction(Uri uri);
//    }
////
//    public void onClick(View v) {
//
//    }

    public void onSubmit(View v) {
        this.activity.onSubmit();
    }

}
