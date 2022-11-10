package com.example.suit_up;

import androidx.appcompat.app.AppCompatActivity;
import com.example.suit_up.UnityShowActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open3DActivity (View view){
        Intent intent = new Intent (this, UnityShowActivity.class);
        startActivity(intent);
    }
}