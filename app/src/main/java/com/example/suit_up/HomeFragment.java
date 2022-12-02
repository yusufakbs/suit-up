package com.example.suit_up;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CardView unityCardView = (CardView) view.findViewById(R.id.imageCard);
        unityCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (HomeFragment.this.getActivity(), UnityModuleActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public void open3DActivity(View view) {
        Intent intent = new Intent (HomeFragment.this.getActivity(), UnityModuleActivity.class);
        startActivity(intent);
    }
}