package com.example.mareu.Features.ReunionFilter;

import com.example.mareu.Base.Mvp;
import com.example.mareu.Features.AddReunion.AddReu;
import com.example.mareu.Model.Reunion;

import java.util.List;

public interface ReuFilter {

    interface View extends Mvp.View{



    }


    interface Presenter extends Mvp.Presenter<AddReu.View>{

        List<Reunion> loadReunions();

    }
}
