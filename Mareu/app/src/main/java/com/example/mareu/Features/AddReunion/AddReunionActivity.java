package com.example.mareu.Features.AddReunion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class AddReunionActivity extends AppCompatActivity implements AddReu.View {

    private AddReunionPresenter mAddReunionPresenter;
    private TextInputLayout mSubject;
    private Button validationButton;
    private DatePickerDialog mDatePickerDialog;
    private TimePickerDialog mTimePickerDialog;
    private Button dateButton;
    private Button timeButton;
    private MultiAutoCompleteTextView mMultiAutoCompleteAttendees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mAddReunionPresenter = new AddReunionPresenter(this);

        mSubject = findViewById(R.id.rSubject);

        dateButton = findViewById(R.id.dateSpinnerButton);
        dateButton.setText(getTodayDate());
        initDatePicker();

        timeButton = findViewById(R.id.timeSpinnerButton);
        timeButton.setText(getTodayTime());
        initTimePicker();

        Spinner spinner = (Spinner) findViewById(R.id.spinnerlocation);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.location_names, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        List<String> ATTENDEES = Arrays.asList(new String[]{
                "amandine@lamzone.com", "luc@lamzone.com", "maxime@lamzone.com", "paul@lamzone.com"});

        mMultiAutoCompleteAttendees = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ATTENDEES);
        mMultiAutoCompleteAttendees.setAdapter(autocompleteAdapter);
        mMultiAutoCompleteAttendees.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        validationButton = findViewById(R.id.validationbutton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createNewReunion();

            }
        });

    }


    private String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private String getTodayTime() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        return makeTimeString(hour, minute);

    }

    private void initDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        mDatePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String time = makeTimeString(hour, minute);
                timeButton.setText(time);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        mTimePickerDialog = new TimePickerDialog(this, style, timeSetListener, hour, minute, true);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;

    }

    private String makeTimeString(int hour, int minute) {
        if (minute < 10) {
            return hour + "H" + "0" + minute;

        } else {

            return hour + "H" + minute;
        }


    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        return "JAN";
    }

    public void openDatePicker(View view) {

        mDatePickerDialog.show();
    }

    public void openTimePicker(View view) {

        mTimePickerDialog.show();
    }

    public void createNewReunion() {
        Spinner spinner = findViewById(R.id.spinnerlocation);
        String rSubject = mSubject.getEditText().getText().toString();
        String rDate = dateButton.getText().toString();
        String rTime = timeButton.getText().toString();
        String rLocation = spinner.getSelectedItem().toString();
        String rAttendees = mMultiAutoCompleteAttendees.getText().toString();

        Reunion newReunion = new Reunion(
                (int) System.currentTimeMillis(),
                rDate,
                rTime,
                rLocation,
                rSubject,
                rAttendees);

        if (checkAllField()) {

            mAddReunionPresenter.addReunion(newReunion);
            Intent intent = new Intent(getApplicationContext(), ReunionActivityList.class);
            startActivity(intent);

        }

    }


    private boolean checkAllField() {

        String checkSubject = mSubject.getEditText().getText().toString();
        String checkAttendees = mMultiAutoCompleteAttendees.getText().toString();

        if (checkSubject.isEmpty()) {
            mSubject.setError("Le champ ne dois pas être vide");
            Toast.makeText(this, "Merci de renseigner le Sujet", Toast.LENGTH_SHORT).show();
            return false;


        } else if (checkAttendees.isEmpty()) {
            mMultiAutoCompleteAttendees.setError("Le champ ne dois pas être vide");
            Toast.makeText(this, "Merci de mettre au moins un participant", Toast.LENGTH_SHORT).show();
            return false;

        } else if (!checkAttendees.contains("@lamzone.com")) {
            mMultiAutoCompleteAttendees.setError("Le champ ne dois pas être vide");
            Toast.makeText(this, "Merci de mettre une adresse au format prenom@lamzone.com", Toast.LENGTH_SHORT).show();
            return false;

        } else {

            mSubject.setError(null);
            mSubject.setErrorEnabled(false);
            return true;
        }

    }


}