package com.example.mareu.Features.AddReunion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Features.Reunions.ReunionPresenter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddReunionActivity extends AppCompatActivity implements AddReu.View {

    private AddReunionPresenter mAddReunionPresenter;

    TextInputLayout mSubject;
    TextInputLayout mDate;
    TextInputLayout mLocation;
    TextInputLayout mAttendees;
    Button validationButton;
    Boolean checkField = false;

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


                checkField = checkAllField();
                if(checkField){

                    mAddReunionPresenter.addReunion(newReunion);
                    Intent intent = new Intent(getApplicationContext(),ReunionActivityList.class);
                    startActivity(intent);

                }


            }
        });
    }



    private boolean checkAllField(){

        String checkSubject = mSubject.getEditText().getText().toString();
        String checkDate = mDate.getEditText().getText().toString();
        String checkLocation = mLocation.getEditText().getText().toString();
        String checkAttendees = mAttendees.getEditText().getText().toString();

        if(checkSubject.isEmpty()){
            mSubject.setError("Le champ ne dois pas être vide");
            Toast.makeText(this,"Merci de renseigner le Sujet",Toast.LENGTH_SHORT).show();
            return false;

        }else if(checkDate.isEmpty()){
            mSubject.setError("Le champ ne dois pas être vide");
            Toast.makeText(this,"Merci de renseigner l'heure",Toast.LENGTH_SHORT).show();
            return false;

        }else if (checkLocation.isEmpty()){
            mSubject.setError("Le champ ne dois pas être vide");
            Toast.makeText(this,"Merci de renseigner une Salle",Toast.LENGTH_SHORT).show();
            return false;

        }else if(checkAttendees.isEmpty()){
            mSubject.setError("Le champ ne dois pas être vide");
            Toast.makeText(this,"Merci de mettre au moins un participant",Toast.LENGTH_SHORT).show();
            return false;

        }else {

            mSubject.setError(null);
            mSubject.setErrorEnabled(false);
            return true;
        }

    }


}