package com.example.mareu.Features.Reunions;

import com.example.mareu.Model.Reunion;

import java.util.List;

public class ReunionPresenter implements Mareu.Presenter{

    private Mareu.View mReunionView;

    public ReunionPresenter(Mareu.View mReunionView) {
        attachView(mReunionView);
    }

    @Override
    public void attachView(Mareu.View view) {
        mReunionView = view;
    }

    @Override
    public List<Reunion> loadReunions() {
        return ReunionModel.getInstance().getReunions();
    }
}
