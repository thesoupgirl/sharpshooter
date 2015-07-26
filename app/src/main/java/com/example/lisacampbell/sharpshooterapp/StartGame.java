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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StartGame.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StartGame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartGame extends Fragment implements OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public SubmitCallbackListener activity;
    private ButtonRectangle startBtn; //camera button
    private TextView label;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StartGame.
     */
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
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_start_game, container, false);
        startBtn = (ButtonRectangle) v.findViewById(R.id.start);
        label = (TextView) v.findViewById(R.id.label);
        label.setGravity(Gravity.CENTER_HORIZONTAL);
        v.findViewById(R.id.start).setOnClickListener(this);
        onClick(v);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onClick(View v) {
        this.activity.onSubmit();
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
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
