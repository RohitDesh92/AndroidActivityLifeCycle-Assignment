package com.example.rohit.activitylifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class MainActivity extends Activity {
    private static Button button_sbm;
    Timer t,timer;
    int count=1;
    TextView tv;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Log.d("start", "onStart()");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.rohit.activitylifecycle/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv = (TextView) findViewById( R.id.textcnt );

        t = new Timer();
        t.scheduleAtFixedRate( new TimerTask() {
            @Override
            public void run() {

                count++;

                runOnUiThread(new Runnable()
                {
                    public void run()
                    {

                        if(count<=100)
                        {
                            tv.setText(""+count);
                        }
                        else
                        {
                            t.cancel();
                        }
                    }
                });
            }
        }, 1000, 1000 );




        Log.d("resume", "onResume()");

    }

    public void redirectToB(View view) {
        if (view.getId() == R.id.ActB) {
            Intent i = new Intent(this, ActivityB.class);
            startActivity(i);
        } else if (view.getId() == R.id.close) {
            //this.onDestroy();
            finish();
        } else if (view.getId() == R.id.Dia) {
            onButtonClickListener();
        }
    }

    public void onButtonClickListener() {
        button_sbm = (Button)findViewById(R.id.Dia);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Do you want to Close this App !!!")
                                .setCancelable(false)
                                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }) ;
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pause", "onPause()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
        Log.d("Destroy", "onDestroy()");
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.rohit.activitylifecycle/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
