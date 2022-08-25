package com.example.mareu.Utils.Event;

import com.example.mareu.Model.Reunion;

public class DeleteReunionEvent {

    public Reunion reunion;

    public DeleteReunionEvent(Reunion reunion) {
        this.reunion = reunion;
    }
}
