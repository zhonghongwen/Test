package com.example.w9001134.rrrrrrrrrr;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("test", "use log.e");

    }

    public void ttt(View view) {

//        Intent intent = new Intent("android.intent.action.BOOT_COMPLETED");
//        intent.setPackage(getPackageName());
//        sendBroadcast(intent);
        if (++index % 2 == 0) {
            setAppState(this,false);
        } else {
            setAppState(this,true);
        }

    }

    private static void setAppState(Context context, boolean install) {
        //#endif VENDOR_EDIT
        PackageManager pm = context.getPackageManager();
        String[] launcherActivity = {
                "com.example.w9001134.rrrrrrrrrr.MainActivity",

        };
        ComponentName cName = new ComponentName("com.example.w9001134.rrrrrrrrrr" +
                "", launcherActivity[0]);
        int state = install ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                : PackageManager.COMPONENT_ENABLED_STATE_DISABLED;

        if (((PackageManager.COMPONENT_ENABLED_STATE_ENABLED == state) &&
                (PackageManager.COMPONENT_ENABLED_STATE_ENABLED ==
                        pm.getComponentEnabledSetting(cName))) ||
                ((PackageManager.COMPONENT_ENABLED_STATE_DISABLED == state) &&
                        (PackageManager.COMPONENT_ENABLED_STATE_DISABLED ==
                                pm.getComponentEnabledSetting(cName)))) {
            Log.e("$zhw======$", "Need not change app state!!");

        } else {
            Log.e("$zhw======$", "Change app state[" + install + "]");
            try {
                pm.setComponentEnabledSetting(cName, state, PackageManager.DONT_KILL_APP);
            } catch (Exception e) {
                Log.e("$zhw======$", "Could not change STK app state"+e.getMessage());
            }
        }
        Log.e("$zhw======$", "[setAppState]-");
    }

}
