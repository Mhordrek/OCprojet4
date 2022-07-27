package com.example.mareu.Features;

import com.example.mareu.Model.MareuReunion;

import java.util.ArrayList;
import java.util.List;

public class MareuModel implements Mareu.Model{

    List<MareuReunion> reunion = new ArrayList<MareuReunion>();
    private static MareuModel  instance = null;
    protected MareuModel(){

        int id = 1;
        String date = "14h00";
        String location = "Réunion A";
        String subject = "Peach";
        String attendees = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion1 = new MareuReunion(id,date,location,subject,attendees);
        reunion.add(reunion1);

        int id2 = 2;
        String date2 = "16h00";
        String location2 = "Réunion B";
        String subject2 = "Mario";
        String attendees2 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion2 = new MareuReunion(id2,date2,location2,subject2,attendees2);
        reunion.add(reunion2);

        int id3 = 3;
        String date3 = "19h00";
        String location3 = "Réunion C";
        String subject3 = "Peach";
        String attendees3 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion3 = new MareuReunion(id3,date3,location3,subject3,attendees3);
        reunion.add(reunion3);

        int id4 = 4;
        String date4 = "14h20";
        String location4 = "Réunion A";
        String subject4 = "Peach";
        String attendees4 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion4 = new MareuReunion(id4,date4,location4,subject4,attendees4);
        reunion.add(reunion4);

        int id5 = 5;
        String date5 = "14h20";
        String location5 = "Réunion A";
        String subject5 = "Peach";
        String attendees5 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion5 = new MareuReunion(id5,date5,location5,subject5,attendees5);
        reunion.add(reunion5);

        int id6 = 6;
        String date6 = "14h20";
        String location6 = "Réunion A";
        String subject6 = "Peach";
        String attendees6 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion6 = new MareuReunion(id6,date6,location6,subject6,attendees6);
        reunion.add(reunion6);

        int id7 = 7;
        String date7 = "14h20";
        String location7 = "Réunion A";
        String subject7 = "Peach";
        String attendees7 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion7 = new MareuReunion(id7,date7,location7,subject7,attendees7);
        reunion.add(reunion7);

        int id8 = 8;
        String date8 = "14h20";
        String location8 = "Réunion A";
        String subject8 = "Peach";
        String attendees8 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion8 = new MareuReunion(id8,date8,location8,subject8,attendees8);
        reunion.add(reunion8);

        int id9 = 9;
        String date9 = "14h20";
        String location9 = "Réunion A";
        String subject9 = "Peach";
        String attendees9 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion9 = new MareuReunion(id9,date9,location9,subject9,attendees9);
        reunion.add(reunion9);

        int id10 = 10;
        String date10 = "14h20";
        String location10 = "Réunion A";
        String subject10 = "Peach";
        String attendees10 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        MareuReunion reunion10 = new MareuReunion(id10,date10,location10,subject10,attendees10);
        reunion.add(reunion10);



    }

    public static MareuModel getInstance() {
        if(instance == null) {
            instance = new MareuModel();
        }
        return instance;
    }
}
