package com.example.lisacampbell.sharpshooterapp;

import android.app.Activity;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BeforePhoto.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BeforePhoto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeforePhoto extends Fragment implements OnClickListener{

    public SubmitCallbackListener activity;
    public MyApp myApp;
    private ButtonRectangle cameraBtn; //camera button
    private TextView top;
    //private OnFragmentInteractionListener mListener;
//    private Drawable camera;

    // TODO: Rename and change types and number of parameters
    public static BeforePhoto newInstance(SubmitCallbackListener activity) {
        BeforePhoto f = new BeforePhoto();

        f.activity = activity;
        return f;
    }

    public BeforePhoto() {
        // Required empty public constructor
    }

    public static Drawable getDrawable(String name) {
        Context context = MyApp.getContext();
        int resourceId = context.getResources().getIdentifier(name, "drawable", MyApp.getContext().getPackageName());
        return ContextCompat.getDrawable(context, resourceId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        top.setGravity(Gravity.CENTER_HORIZONTAL);
        onSubmit(v);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void onClick(View v) {

    }

    public void onSubmit(View v) {

    }

}
