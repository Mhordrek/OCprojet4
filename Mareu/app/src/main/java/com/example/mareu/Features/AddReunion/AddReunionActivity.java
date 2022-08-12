package com.example.mareu.Features.AddReunion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Features.Reunions.ReunionPresenter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class AddReunionActivity extends AppCompatActivity implements AddReu.View {

    private AddReunionPresenter mAddReunionPresenter;

    TextInputLayout mSubject;
    TextInputLayout mDate;
    TextInputLayout mLocation;
    TextInputLayout mAttendees;
    Button validationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mAddReunionPresenter = new AddReunionPresenter(this);
        mSubject = findViewById(R.id.rSubject);
        mDate = findViewById(R.id.rDate);
        mLocation = findViewById(R.id.rLocation);
        mAttendees = findViewById(R.id.rAttendees);

        validationButton = findViewById(R.id.validationbutton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rSubject = mSubject.getEditText().getText().toString();
                String rDate = mDate.getEditText().getText().toString();
                String rLocation = mLocation.getEditText().getText().toString();
                String rAttendees = mAttendees.getEditText().getText().toString();

                Reunion newReunion = new Reunion(
                        (int) System.currentTimeMillis(),
                        rSubject,
                        rDate,
                        rLocation,
                        rAttendees);

                mAddReunionPresenter.addReunion(newReunion);
                Intent intent = new Intent(getApplicationContext(),ReunionActivityList.class);
                startActivity(intent);

            }
        });
    }


}