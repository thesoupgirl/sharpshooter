package com.example.lisacampbell.sharpshooterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import com.gc.materialdesign.views.ButtonRectangle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.content.Context;


public class FirstLoginActivity extends AppCompatActivity implements SubmitCallbackListener{

    private FirstLoginActivityFragment firstLoginActivityFragment;
    private BeforePhoto beforePhoto;
    private StartGame startGame;

//    public FirstLoginActivity firstLogin = new FirstLoginActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);
        this.firstLoginActivityFragment = FirstLoginActivityFragment.newInstance(this);
        this.beforePhoto = BeforePhoto.newInstance(this);
        this.startGame = StartGame.newInstance(this);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment, this.firstLoginActivityFragment);
        ft.commit();


    }

    public void replaceDataFragment(Fragment fra){
        android.app.FragmentTransaction ftr = getFragmentManager().beginTransaction();
        ftr.replace(R.id.content_frame, fra);
        ftr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ftr.commit();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_first_login, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        StartGame frag = StartGame.newInstance(this);

        ft.replace(R.id.start_game, frag);
        Log.d("fuck me", "blow me");
        ft.commit();
    }
    public void onSubmit() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        StartGame frag = StartGame.newInstance(this);

        ft.replace(R.id.first, frag);
        Log.d("fuck me", "blow me");
        ft.commit();
    }

    public void onSubmit(int j) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        BeforePhoto frag = BeforePhoto.newInstance(this);

        ft.replace(R.id.start_game, frag);
        Log.d("fuck me", "blow me");
        ft.commit();
    }

    public static Drawable getDrawable(String name) {
        Context context = MyApp.getContext();
        int resourceId = context.getResources().getIdentifier(name, "drawable", MyApp.getContext().getPackageName());
        return context.getResources().getDrawable(resourceId);
    }
}
