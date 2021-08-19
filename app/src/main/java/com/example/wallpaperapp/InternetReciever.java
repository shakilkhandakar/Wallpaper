package com.example.wallpaperapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            try {
                if (isOnline(context)){
                    Toast.makeText(context, "Network Connected", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "No Network Connection", Toast.LENGTH_SHORT).show();
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }
    }
    public boolean isOnline(Context context){

        try {
            ConnectivityManager cn= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo network=cn.getActiveNetworkInfo();
            return (network!=null && network.isConnected());
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}