package com.example.mareu.Features.ReunionFilter;

import com.example.mareu.Features.AddReunion.AddReu;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Model.Reunion;

import java.util.List;

public class ReuFilterPresenter implements ReuFilter.Presenter{
    @Override
    public void attachView(AddReu.View view) {

    }

    @Override
    public List<Reunion> loadReunions() {
        return ReunionModel.getInstance().getReunions();
    }
}
