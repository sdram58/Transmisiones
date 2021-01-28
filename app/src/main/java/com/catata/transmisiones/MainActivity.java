package com.catata.transmisiones;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver br;
    IntentFilter filter;

    public static final String MY_ACTION_RECEIVER = MainActivity.class.getCanonicalName() + ".ACTION_RECEIVER";
    public static final String MY_ACTION_RECEIVER_EXTRA = MainActivity.class.getCanonicalName() + ".RECEIVER_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG", MY_ACTION_RECEIVER);
/*
        br = new MyBroadcastReceiver();

        filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(MY_ACTION_RECEIVER);
*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(br, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(br);
    }

    public void onClick(View view) {

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MY_ACTION_RECEIVER);
                intent.putExtra(MY_ACTION_RECEIVER_EXTRA,"Enviado");

                sendBroadcast(intent, Manifest.permission.INTERNET);
            }
        },5000);

    }
}