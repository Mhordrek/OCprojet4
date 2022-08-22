package com.example.mareu.Features.AddReunion;

import com.example.mareu.Features.Reunions.Mareu;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Model.Reunion;

import java.util.List;

public class AddReunionPresenter implements AddReu.Presenter{

    private AddReu.View mAddReunionView;

    public AddReunionPresenter(AddReu.View mAddReunionView) {
        attachView(mAddReunionView);
    }


    @Override
    public void attachView(AddReu.View view) {

        mAddReunionView = view;


    }

    @Override
    public void addReunion(Reunion reunion) {

        ReunionModel.getInstance().addReunion(reunion);
    }
}
