package com.example.mareu.Features.AddReunion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class AddReunionActivity extends AppCompatActivity implements AddReu.View {

    private AddReunionPresenter mAddReunionPresenter;
    TextInputLayout mSubject;
    Button validationButton;
    Boolean checkField = false;
    private DatePickerDialog mDatePickerDialog;
    private Button dateButton;
    private MultiAutoCompleteTextView mMultiAutoCompleteAttendees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mAddReunionPresenter = new AddReunionPresenter(this);
        mSubject = findViewById(R.id.rSubject);


        dateButton = findViewById(R.id.datespinnerbutton);
        dateButton.setText(getTodaysDate());
        initDatePicker();

        Spinner spinner = (Spinner) findViewById(R.id.spinnerlocation);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.location_names, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


        mMultiAutoCompleteAttendees = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ATTENDEES);
        mMultiAutoCompleteAttendees.setAdapter(autocompleteAdapter);
        mMultiAutoCompleteAttendees.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        validationButton = findViewById(R.id.validationbutton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rSubject = mSubject.getEditText().getText().toString();
                String rDate = dateButton.getText().toString();
                String rLocation = spinner.getSelectedItem().toString();
                String rAttendees = mMultiAutoCompleteAttendees.getText().toString();

                Reunion newReunion = new Reunion(
                        (int) System.currentTimeMillis(),
                        rSubject,
                        rDate,
                        rLocation,
                        rAttendees);


                checkField = checkAllField();
                if(checkField){

                    mAddReunionPresenter.addReunion(newReunion);
                    Intent intent = new Intent(getApplicationContext(),ReunionActivityList.class);
                    startActivity(intent);

                }

            }
        });
    }

    List<String> ATTENDEES = Arrays.asList(new String[]{
            "amandine@lamzone.com","luc@lamzone.com","maxime@lamzone.com","paul@lamzone.com"});


    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void initDatePicker(){

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;
                String date = makeDateString(day,month,year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        mDatePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;

    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        return "Jan";
    }

    public void openDatePicker(View view){

        mDatePickerDialog.show();
    }


    private boolean checkAllField(){

        String checkSubject = mSubject.getEditText().getText().toString();
        String checkAttendees = mMultiAutoCompleteAttendees.getText().toString();

        if(checkSubject.isEmpty()){
            mSubject.setError("Le champ ne dois pas être vide");
            Toast.makeText(this,"Merci de renseigner le Sujet",Toast.LENGTH_SHORT).show();
            return false;


        }else if(checkAttendees.isEmpty()){
            mMultiAutoCompleteAttendees.setError("Le champ ne dois pas être vide");
            Toast.makeText(this,"Merci de mettre au moins un participant",Toast.LENGTH_SHORT).show();
            return false;

        }else {

            mSubject.setError(null);
            mSubject.setErrorEnabled(false);
            return true;
        }

    }


}