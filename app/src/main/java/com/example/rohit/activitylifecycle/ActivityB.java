package com.example.rohit.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class ActivityB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);



    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("resu", "onResume() B");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("stB","onStop() B") ;
    }
    protected void onPause()
    {
        super.onResume();
        Log.d("onp","onResume() B");
    }
}
