package com.example.suit_up;

import com.unity3d.player.UnityPlayer;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;


public class UnityModuleActivity extends AppCompatActivity{
    private UnityPlayer mUnityPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mUnityPlayer = new UnityPlayer(this);
        int glesMode = mUnityPlayer.getSettings().getInt("gles_mode", 1);
        boolean trueColor8888 = false;
        mUnityPlayer.init(glesMode, trueColor8888);

        setContentView(R.layout.unity_module_activity);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.unityFrameLayout);
        LayoutParams layoutParameters = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        frameLayout.addView(mUnityPlayer.getView(), 0, layoutParameters);

        mUnityPlayer.windowFocusChanged(true);
        mUnityPlayer.resume();

    }
}