package com.example.mareu.Features.ReunionFilter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.example.mareu.Utils.Adapter.MareuRecyclerViewAdapter;
import com.example.mareu.Utils.Event.FilterLocationEvent;
import com.google.android.material.datepicker.MaterialDatePicker;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class FilterLocationDialogFragment extends DialogFragment implements ReuFilter.View {

    private EditText mEditText;
    private ReuFilterPresenter mReuFilterPresenter;
    Button mLocationMario;
    Button mLocationLuigi;
    Button mLocationPeach;
    Button mLocationBrowser;



    public FilterLocationDialogFragment() {

        // Empty constructor is required for DialogFragment

        // Make sure not to add arguments to the constructor

        // Use `newInstance` instead as shown below

    }



    public static FilterLocationDialogFragment newInstance(String title) {

        FilterLocationDialogFragment frag = new FilterLocationDialogFragment();

        Bundle args = new Bundle();

        args.putString("title", title);

        frag.setArguments(args);

        return frag;

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.location_filter_dialog, container);

    }



    @Override

    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        mReuFilterPresenter = new ReuFilterPresenter();


        // Get field from view

        mLocationMario = view.findViewById(R.id.salle_mario);
        mLocationLuigi = view.findViewById(R.id.salle_luigi);
        mLocationPeach = view.findViewById(R.id.salle_peach);
        mLocationBrowser = view.findViewById(R.id.salle_browser);


        mLocationMario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EventBus.getDefault().post(new FilterLocationEvent("Mario"));
                getDialog().dismiss();

            }
        });

        mLocationLuigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EventBus.getDefault().post(new FilterLocationEvent("Luigi"));
                getDialog().dismiss();

            }
        });

        mLocationPeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EventBus.getDefault().post(new FilterLocationEvent("Peach"));
                getDialog().dismiss();

            }
        });

        mLocationBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EventBus.getDefault().post(new FilterLocationEvent("Browser"));
                getDialog().dismiss();

            }
        });


        // Fetch arguments from bundle and set title

        String title = getArguments().getString("title", "Choisissez une salle");

        getDialog().setTitle(title);

        // Show soft keyboard automatically and request focus to field


        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

}
