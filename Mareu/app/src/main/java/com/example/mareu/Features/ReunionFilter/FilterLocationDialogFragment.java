package com.example.mareu.Features.ReunionFilter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import java.util.List;

public class FilterLocationDialogFragment extends DialogFragment {

    private EditText mEditText;
    Button mLocationMario;
    Button mLocationLuigi;
    Button mLocationPeach;
    Button mLocationBrowser;
    Button mLocationAll;



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


        // Get field from view

        mLocationMario = view.findViewById(R.id.salle_mario);
        mLocationLuigi = view.findViewById(R.id.salle_luigi);
        mLocationPeach = view.findViewById(R.id.salle_peach);
        mLocationBrowser = view.findViewById(R.id.salle_browser);
        mLocationAll = view.findViewById(R.id.salle_all);


        mLocationMario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ReunionActivityList) getActivity()).filterLocation("Mario");
                getDialog().dismiss();


            }
        });

        mLocationLuigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ((ReunionActivityList) getActivity()).filterLocation("Luigi");
                getDialog().dismiss();

            }
        });

        mLocationPeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ((ReunionActivityList) getActivity()).filterLocation("Peach");
                getDialog().dismiss();

            }
        });

        mLocationBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ((ReunionActivityList) getActivity()).filterLocation("Browser");
                getDialog().dismiss();

            }
        });

        mLocationAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               List<Reunion> reunions = ReunionModel.getInstance().getReunions();
                ((ReunionActivityList) getActivity()).showReunions(reunions);
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
