package com.example.mareu.Features.Reunions;

import com.example.mareu.Model.Reunion;

import java.util.List;

public class ReunionPresenter implements Mareu.Presenter {

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

    @Override
    public void removeReunion(Reunion reunion) {
        ReunionModel.getInstance().removeReunion(reunion);
    }

    @Override
    public List<Reunion> filterLocation(String location) {
        return ReunionModel.getInstance().filterReunions(location);
    }

    @Override
    public List<Reunion> filterDate(Long starDate, Long endDate) {
        return ReunionModel.getInstance().filterDateReunions(starDate, endDate);
    }


}
