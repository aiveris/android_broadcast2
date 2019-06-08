package com.example.broadcast2;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public MyBroadcastReceiver() { }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("RECEIVER", intent.getAction() + "=========");

        if(intent.getAction().equals("com.apps.yo.broadcastalarmmanager")){
            Toast.makeText(context, "OtherApp's BroadCast Received!", Toast.LENGTH_LONG).show();
            Log.e("RECEIVER","info string: " + intent.getStringExtra("info") );
        }
        else if(intent.getAction().equals("com.apps.yo.broadcastfromotherapp.Self")){
            Toast.makeText(context, "Self-BroadCast Received!", Toast.LENGTH_LONG).show();
            Log.e("RECEIVER","Received my Self Broadcast");
        }

    }
}