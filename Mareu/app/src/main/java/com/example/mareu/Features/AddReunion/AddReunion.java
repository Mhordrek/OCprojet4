package com.example.mareu.Features.AddReunion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;

import java.util.ArrayList;
import java.util.List;

public class AddReunion extends AppCompatActivity {

    ReunionModel reunions;
    TextView mSubject;
    TextView mDate;
    TextView mLocation;
    TextView mAttendees;
    Button validationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);

        validationButton = findViewById(R.id.validationbutton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rSubject = mSubject.getText().toString();
                String rDate = mDate.getText().toString();
                String rLocation = mLocation.getText().toString();
                String rAttendees = mAttendees.getText().toString();

                Reunion newReunion = new Reunion(
                        (int) System.currentTimeMillis(),
                        rSubject,
                        rDate,
                        rLocation,
                        rAttendees);

                reunions.getReunions().add(newReunion);
                Intent intent = new Intent(getApplicationContext(),ReunionActivityList.class);
                startActivity(intent);

            }
        });
    }


}