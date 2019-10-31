package com.example.w9001134.rrrrrrrrrr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Time:2019/10/23
 * Author:zhw
 * Description:
 */
public class BootCompletedReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.e("$zhw======$","action:"+action);
        if (intent.getAction().equals(ACTION)) {
            Log.e("$zhw======$","action:开机");
            Toast.makeText(context, "开机", Toast.LENGTH_SHORT).show();
            FileUtil.write("/sdcard/zhw/start.txt");

        } else if (action.equals(Intent.ACTION_SHUTDOWN)) {
            FileUtil.write("/sdcard/zhw/end.txt");
            Log.e("$zhw======$","===================关机");
        }
    }
}
