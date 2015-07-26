package com.example.lisacampbell.sharpshooterapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.gc.materialdesign.views.ButtonRectangle;
import android.util.Log;

/**
 * A placeholder fragment containing a simple view.
 */
public class FirstLoginActivityFragment extends Fragment implements OnClickListener {
    public SubmitCallbackListener activity;
    private TextView login; //text at top, static
    private EditText name; //place holder name of user
    private ButtonRectangle next; //next button
    public static String userName; //value inputted by user
    public boolean clicky = false;

    public FirstLoginActivityFragment() {
    }
    public static FirstLoginActivityFragment newInstance(SubmitCallbackListener activity) {
        FirstLoginActivityFragment f = new FirstLoginActivityFragment();

        f.activity = activity;
        return f;
    }
    @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
        View blah = inflater.inflate(R.layout.fragment_first_login, container, false);
        login = (TextView) blah.findViewById(R.id.login);
        name = (EditText) blah.findViewById(R.id.name);
        next = (ButtonRectangle) blah.findViewById(R.id.next);

        blah.findViewById(R.id.next).setOnClickListener(this);

//        next.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        userName = name.getText().toString();
//                        clicky = true;
//                    }
//                }
//        );

    return blah;
  }

    public static String getName() {
        return userName;
        //return this.name != null ? name.getText().toString() : defaultVal;
    }

    @Override
    public void onClick(View v) {
        userName = name.getText().toString();
        this.activity.onSubmit();
    }
}
