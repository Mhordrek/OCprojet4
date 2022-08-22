package com.example.mareu.Features.Reunions;

import com.example.mareu.Model.Reunion;

import java.util.ArrayList;
import java.util.List;

public class ReunionModel implements Mareu.Model{

    List<Reunion> reunions = new ArrayList<Reunion>();
    private static ReunionModel instance = null;
    protected ReunionModel(){

        int id = 1;
        String date = "14h00";
        String location = "Peach" ;
        String subject = "Réunion A";
        String attendees = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion1 = new Reunion(id,date,location,subject,attendees);
        reunions.add(reunion1);

        int id2 = 2;
        String date2 = "16h00";
        String location2 = "Mario" ;
        String subject2 = "Réunion B";
        String attendees2 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion2 = new Reunion(id2,date2,location2,subject2,attendees2);
        reunions.add(reunion2);

        int id3 = 3;
        String date3 = "19h00";
        String location3 = "Luigi";
        String subject3 = "Réunion C";
        String attendees3 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion3 = new Reunion(id3,date3,location3,subject3,attendees3);
        reunions.add(reunion3);

        int id4 = 4;
        String date4 = "09h00";
        String location4 = "Browser";
        String subject4 = "Réunion D";
        String attendees4 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion4 = new Reunion(id4,date4,location4,subject4,attendees4);
        reunions.add(reunion4);

        int id5 = 5;
        String date5 = "16h30";
        String location5 = "Peach";
        String subject5 = "Réunion E";
        String attendees5 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion5 = new Reunion(id5,date5,location5,subject5,attendees5);
        reunions.add(reunion5);

        int id6 = 6;
        String date6 = "08h30";
        String location6 = "Mario";
        String subject6 = "Réunion F";
        String attendees6 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion6 = new Reunion(id6,date6,location6,subject6,attendees6);
        reunions.add(reunion6);

        int id7 = 7;
        String date7 = "17h00";
        String location7 = "Luigi";
        String subject7 = "Réunion G";
        String attendees7 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion7 = new Reunion(id7,date7,location7,subject7,attendees7);
        reunions.add(reunion7);

        int id8 = 8;
        String date8 = "10h00";
        String location8 = "Browser";
        String subject8 = "Réunion H";
        String attendees8 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion8 = new Reunion(id8,date8,location8,subject8,attendees8);
        reunions.add(reunion8);

        int id9 = 9;
        String date9 = "10h30";
        String location9 = "Peach";
        String subject9 = "Réunion I";
        String attendees9 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion9 = new Reunion(id9,date9,location9,subject9,attendees9);
        reunions.add(reunion9);

        int id10 = 10;
        String date10 = "13h00";
        String location10 = "Mario";
        String subject10 = "Réunion J";
        String attendees10 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion10 = new Reunion(id10,date10,location10,subject10,attendees10);
        reunions.add(reunion10);



    }

    public static ReunionModel getInstance() {
        if(instance == null) {
            instance = new ReunionModel();
        }
        return instance;
    }

    @Override
    public List<Reunion> getReunions() {
        return reunions;
    }

    @Override
    public void addReunion(Reunion reunion) {
        reunions.add(reunion);
    }

    @Override
    public void removeReunion(Reunion reunion) {
        reunions.remove(reunion);
    }


}
