package com.example.mareu.Features.Reunions;

import com.example.mareu.Base.Mvp;
import com.example.mareu.Model.Reunion;

import java.util.List;

public interface Mareu {

    interface View extends Mvp.View{

        void showReunions(List<Reunion> shows);
    }

    interface Model extends Mvp.Model{
        List<Reunion> getReunions();
        void addReunion(Reunion reunion);
        void removeReunion(Reunion reunion);

    }

    interface Presenter extends Mvp.Presenter<View>{
        List<Reunion> loadReunions();
        void removeReunion(Reunion reunion);


    }

}
