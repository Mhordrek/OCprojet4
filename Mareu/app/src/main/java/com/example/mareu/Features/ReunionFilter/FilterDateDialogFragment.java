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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

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

        MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.dateRangePicker().setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("datetest", "test calendrier");
                materialDatePicker.show(getParentFragmentManager(), "date_picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        dateText.setText(materialDatePicker.getHeaderText());
                    }
                });

            }
        });

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Show soft keyboard automatically and request focus to field


        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

}
