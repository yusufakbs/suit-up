package com.example.suit_up;

import com.google.android.material.navigation.NavigationView;
import com.unity3d.player.UnityPlayerActivity;
import com.unity3d.player.UnityPlayer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;

import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;


public class UnityModuleActivity extends Activity {
    private UnityPlayer mUnityPlayer;

//    private DrawerLayout mDrawer;
//    private NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mUnityPlayer = new UnityPlayer(this);
        int glesMode = mUnityPlayer.getSettings().getInt("gles_mode", 1);
        boolean trueColor8888 = false;
        mUnityPlayer.init(glesMode, trueColor8888);
        //Set the content to main
        setContentView(R.layout.unity_module_activity);

        //Inflate the frame layout from XML
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.unityFrameLayout);
        LayoutParams layoutParameters = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        frameLayout.addView(mUnityPlayer.getView(), 0, layoutParameters);
        mUnityPlayer.windowFocusChanged(true);
        mUnityPlayer.resume();
    }
}