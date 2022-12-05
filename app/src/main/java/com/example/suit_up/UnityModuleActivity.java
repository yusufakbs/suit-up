package com.example.suit_up;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.unity3d.player.UnityPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class UnityModuleActivity extends AppCompatActivity{
    private UnityPlayer mUnityPlayer;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mUnityPlayer = new UnityPlayer(this);
        int glesMode = mUnityPlayer.getSettings().getInt("gles_mode", 1);
        boolean trueColor8888 = false;
        mUnityPlayer.init(glesMode, trueColor8888);

        setContentView(R.layout.unity_module_activity);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.unityFrameLayout);
        ExtendedFloatingActionButton e_fab = (ExtendedFloatingActionButton) findViewById(R.id.extended_fab);
        ExtendedFloatingActionButton fab = (ExtendedFloatingActionButton) findViewById(R.id.extended_size_button);
        e_fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openPopUpWardrobe(v);
            }
        });

//        ScrollView wardrobeView = (ScrollView) findViewById(R.layout.wardrobe_pop_up_layout);
//        CardView unityCardView = (CardView) war.findViewById(R.id.cloth_1_size_s);
//        unityCardView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                UnityPlayer.UnitySendMessage("ClothManager", "activate_cloth_1_size_s", "Test");
//            }
//        });


        ExtendedFloatingActionButton closer_view_fab = (ExtendedFloatingActionButton) findViewById(R.id.closer_view_fab);
//        fab.setVisibility(View.GONE);


        LayoutParams layoutParameters = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        frameLayout.addView(mUnityPlayer.getView(), 0, layoutParameters);

//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        mUnityPlayer.windowFocusChanged(true);
        mUnityPlayer.resume();

    }

    public void openPopUpWardrobe(View view){
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.wardrobe_pop_up_layout, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, 850, 1500, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        popupWindow.getContentView().findViewById(R.id.cloth_1_size_s).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                UnityPlayer.UnitySendMessage("ClothManager", "activate_cloth_1_size_s", "Test");
                popupWindow.dismiss();
            }
        });
    }

    public void switchClothes(View view) {

        if (view.getId() == R.id.cloth_1) {
//            UnityPlayer.UnitySendMessage("cloth_3", "dummyMethod", null);
        } else if (view.getId() == R.id.cloth_2) {
//            UnityPlayer.UnitySendMessage("cloth_3", "dummyMethod2", null);

        }
    }

    public void zoomInOutClick(View view) {
        UnityPlayer.UnitySendMessage("mainCamera", "changeCameraState", "Test");
    }
}