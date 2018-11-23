package com.example.android.androidme.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_me);
if(savedInstanceState==null) {




    BodyFragmentPart headFragment = new BodyFragmentPart();
    headFragment.setImageIds(AndroidImageAssets.getHeads());
    int headIndex = getIntent().getIntExtra("headIndex", 0);
    headFragment.setListIndex(headIndex);
    FragmentManager fragmentManager = getSupportFragmentManager();


    fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();


    BodyFragmentPart bodyFragment = new BodyFragmentPart();
    bodyFragment.setImageIds(AndroidImageAssets.getBodies());
    int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
    bodyFragment.setListIndex(bodyIndex);

    fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();


    BodyFragmentPart legFragment = new BodyFragmentPart();
    legFragment.setImageIds(AndroidImageAssets.getLegs());
    int legIndex = getIntent().getIntExtra("legIndex", 0);
    legFragment.setListIndex(legIndex);
    fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();

}



    }
}

