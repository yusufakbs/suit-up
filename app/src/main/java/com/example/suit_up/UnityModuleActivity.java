package com.example.suit_up;

import com.unity3d.player.UnityPlayerActivity;
import android.os.Bundle;
import android.util.Log;


public class UnityModuleActivity extends UnityPlayerActivity {
    protected void onCreate(Bundle savedInstanceState) {
        // Calls UnityPlayerActivity.onCreate()
        super.onCreate(savedInstanceState);
        // Prints debug message to Logcat
        Log.d("OverrideActivity", "onCreate called!");
    }
    public void onBackPressed()
    {
        // Instead of calling UnityPlayerActivity.onBackPressed(), this example ignores the back button event
        // super.onBackPressed();
    }
}