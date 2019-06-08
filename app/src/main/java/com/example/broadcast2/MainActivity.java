package com.example.broadcast2;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //makeReceiver(); //for android 8+ only mentioning intent filter in Manifest wont work
        Toast.makeText(this, "All Ready....", Toast.LENGTH_SHORT).show();
    }

    private void makeReceiver() {
        IntentFilter filter = new IntentFilter();

        filter.addAction("com.apps.yo.broadcastalarmmanager");
        filter.addAction("com.apps.yo.broadcastfromotherapp.self");
        receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, filter);
    }

    public void makeSelfBroadcast(View v){
        Log.e("BroadCasted","self broadcast started...");
        Intent intent = new Intent();
        intent.setAction("com.apps.yo.broadcastfromotherapp.Self");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);

        Toast.makeText(this, "...wait for Self Broadcast", Toast.LENGTH_LONG).show();
    }
}
