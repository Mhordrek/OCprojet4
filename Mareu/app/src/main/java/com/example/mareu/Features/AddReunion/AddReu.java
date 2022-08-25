package com.example.mareu.Features.AddReunion;

import com.example.mareu.Base.Mvp;
import com.example.mareu.Model.Reunion;

import java.util.List;

public interface AddReu {

    interface View extends Mvp.View{


    }


    interface Presenter extends Mvp.Presenter<View>{

        void addReunion(Reunion reunion);
        List<Reunion> loadReunions();

    }

}
