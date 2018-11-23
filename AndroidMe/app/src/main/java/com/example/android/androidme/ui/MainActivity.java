package com.example.android.androidme.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.androidme.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.onImageClickListener{
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onImageSelected(int position) {


        int bodyPartNumber=position/12;
        int listIndex=position-12*bodyPartNumber;
        switch (bodyPartNumber){
            case 0:headIndex=listIndex;
            break;
            case 1:bodyIndex=listIndex;
            break;
            case 2:legIndex=listIndex;
            break;
            default:break;
        }



        Bundle b=new Bundle();
        b.putInt("headIndex",headIndex);

        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);
        final Intent intent=new Intent(this,AndroidMeActivity.class);
        intent.putExtras(b);
        Button btn=(Button)findViewById(R.id.next_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}
