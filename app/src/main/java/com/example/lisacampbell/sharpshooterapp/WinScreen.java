package com.example.lisacampbell.sharpshooterapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gc.materialdesign.views.ButtonRectangle;

import org.w3c.dom.Text;


public class WinScreen extends Fragment {

    private SubmitCallbackListener activity;
    private ButtonRectangle newBtn;
    private TextView label;
    public String thingy;




    //private OnFragmentInteractionListener mListener;


    // TODO: Rename and change types and number of parameters
    public static WinScreen newInstance(SubmitCallbackListener activity) {
        WinScreen fragment = new WinScreen();
        fragment.activity = activity;
        return fragment;
    }

    public WinScreen() {
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
        View v = inflater.inflate(R.layout.fragment_win_screen, container, false);
        newBtn = (ButtonRectangle) v.findViewById(R.id.newgame);
        label = (TextView) v.findViewById(R.id.label);
        //FirstLoginActivityFragment firstLoginActivityFragment = new FirstLoginActivityFragment();
        thingy = FirstLoginActivityFragment.getName();
        thingy = "Congrats!  " + thingy + ", you won!";
        label.setText((CharSequence) thingy);
        // label.setGravity(Gravity.CENTER_HORIZONTAL);
        //v.findViewById(R.id.start).setOnClickListener();
        newBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment frag = new FirstLoginActivityFragment();


                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.first, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        //onSubmit(v);
        return v;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

}
