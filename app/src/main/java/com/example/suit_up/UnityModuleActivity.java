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
    private ExtendedFloatingActionButton sizeS_FAB;
    private ExtendedFloatingActionButton sizeM_FAB;
    private ExtendedFloatingActionButton sizeL_FAB;
    boolean isFABOpen;

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
        e_fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openPopUpWardrobe(v);
            }
        });

        ExtendedFloatingActionButton closer_view_fab = (ExtendedFloatingActionButton) findViewById(R.id.closer_view_fab);
//        fab.setVisibility(View.GONE);

        ExtendedFloatingActionButton sizeFAB = (ExtendedFloatingActionButton) findViewById(R.id.extended_size_button);
        sizeS_FAB = (ExtendedFloatingActionButton) findViewById(R.id.size_s_button);
        sizeM_FAB = (ExtendedFloatingActionButton) findViewById(R.id.size_m_button);
        sizeL_FAB = (ExtendedFloatingActionButton) findViewById(R.id.size_l_button);
        sizeFAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu(view);
                }else{
                    closeFABMenu(view);
                }
            }
        });

        sizeS_FAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UnityPlayer.UnitySendMessage("cloth_1_size_s", "activateCloth", "Text");
            }
        });

        sizeM_FAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UnityPlayer.UnitySendMessage("cloth_1_size_s", "deactivateCloth", "Text");
            }
        });

        LayoutParams layoutParameters = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        frameLayout.addView(mUnityPlayer.getView(), 0, layoutParameters);

        mUnityPlayer.windowFocusChanged(true);
        mUnityPlayer.resume();

    }

    public void openPopUpWardrobe(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.wardrobe_pop_up_layout, null);
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

        popupWindow.getContentView().findViewById(R.id.cloth_1_size_m).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                UnityPlayer.UnitySendMessage("ClothManager", "activate_cloth_1_size_m", "Test");
                popupWindow.dismiss();
            }
        });
    }


    public void zoomInOutClick(View view) {
        UnityPlayer.UnitySendMessage("mainCamera", "changeCameraState", "Test");
    }

    private void showFABMenu(View view){
        isFABOpen=true;
        sizeS_FAB.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        sizeM_FAB.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        sizeL_FAB.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
    }

    private void closeFABMenu(View view){
        isFABOpen=false;
        sizeS_FAB.animate().translationY(0);
        sizeM_FAB.animate().translationY(0);
        sizeL_FAB.animate().translationY(0);
    }
}