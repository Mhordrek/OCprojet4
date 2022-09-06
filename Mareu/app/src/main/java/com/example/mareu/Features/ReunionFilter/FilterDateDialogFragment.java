package com.example.mareu.Features.ReunionFilter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.example.mareu.Utils.Adapter.MareuRecyclerViewAdapter;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.List;

public class FilterDateDialogFragment extends DialogFragment {

    private EditText mEditText;
    TextView dateText;
    Button calendar;
    Button validation;


    public FilterDateDialogFragment() {

        // Empty constructor is required for DialogFragment

        // Make sure not to add arguments to the constructor

        // Use `newInstance` instead as shown below

    }


    public static FilterDateDialogFragment newInstance(String title) {

        FilterDateDialogFragment frag = new FilterDateDialogFragment();

        Bundle args = new Bundle();

        args.putString("title", title);

        frag.setArguments(args);

        return frag;

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.date_filter_dialog, container);

    }


    @Override

    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        dateText = view.findViewById(R.id.date_text);
        calendar = view.findViewById(R.id.date_calendar);
        validation = view.findViewById(R.id.date_calendar_validation);


        // Fetch arguments from bundle and set title

        String title = getArguments().getString("title", "Choisissez une date");

        getDialog().setTitle(title);

        MaterialDatePicker<Pair<Long, Long>> materialDatePicker = MaterialDatePicker.Builder.dateRangePicker().setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("datetest", "test calendrier");
                materialDatePicker.show(getParentFragmentManager(), "date_picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair<Long, Long> selection) {
                        Long startDate = selection.first;
                        Long endDate = selection.second;

                        dateText.setText(materialDatePicker.getHeaderText());

                        ReunionModel.getInstance().filterDateReunions(startDate,endDate);

                    }
                });

            }
        });

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ReunionActivityList) getActivity()).filterDate(startDate,endDate);

            }
        });

        // Show soft keyboard automatically and request focus to field


        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

}
