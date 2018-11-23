package com.example.android.androidme.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyFragmentPart extends Fragment {
    public static final String IMAGE_ID_LIST="image_id_list";
    public static final String LIST_INDEX="list_index";

    private List<Integer>mImageIds;
    private int mListIndex;

public BodyFragmentPart(){

}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);

        if(savedInstanceState!=null){
  mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
  mListIndex=savedInstanceState.getInt(LIST_INDEX);


        }

      final  ImageView imageView=(ImageView)rootView.findViewById(R.id.body_part_image_view);
       if(mImageIds!=null)
           imageView.setImageResource(mImageIds.get(mListIndex));

       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(mListIndex<mImageIds.size()-1)
                   mListIndex++;
               else
                   mListIndex=0;
               imageView.setImageResource(mImageIds.get(mListIndex));


           }
       });

         return rootView;

    }

    public void setImageIds(List<Integer> imageIds) {
        this.mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        this.mListIndex = index;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
        outState.putInt(LIST_INDEX,mListIndex);
    }
}
