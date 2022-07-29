package com.example.mareu.Features.Reunions;

import com.example.mareu.Features.Reunions.Mareu;
import com.example.mareu.Features.Reunions.MareuModel;
import com.example.mareu.Model.Reunion;

import java.util.List;

public class MareuPresenter implements Mareu.Presenter{

    private Mareu.View mTvShowsView;

    public MareuPresenter(Mareu.View mTvShowsView) {
        attachView(mTvShowsView);
    }

    @Override
    public void attachView(Mareu.View view) {
        mTvShowsView = view;
    }

    @Override
    public List<Reunion> loadReunions() {
        return MareuModel.getInstance().getReunions();
    }
}
