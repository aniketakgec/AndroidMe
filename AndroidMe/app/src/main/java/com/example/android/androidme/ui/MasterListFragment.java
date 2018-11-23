package com.example.android.androidme.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    onImageClickListener mCallback;
    public interface onImageClickListener{
        void onImageSelected(int postion);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback=(onImageClickListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must Implement onI ageClickListener");
        }
    }

    // Mandatory empty constructor
    public MasterListFragment() {
    }



    // Inflates the GridView of all AndroidMe images
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment__master_list, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);

gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCallback.onImageSelected(position);
    }
});










        // Return the root view
        return rootView;
    }

}