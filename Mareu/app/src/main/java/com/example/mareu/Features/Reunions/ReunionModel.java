package com.example.mareu.Features.Reunions;

import android.util.Log;

import com.example.mareu.Model.Reunion;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ReunionModel implements Mareu.Model {


    private static ReunionModel instance = null;
    private static final String TAG = "ReunionModel";

    List<Reunion> reunions = new ArrayList<Reunion>();

    public static List<Reunion> DUMMY_REUNIONS = Arrays.asList(
            new Reunion(1, "AUG 25 2022", "14H30", "Peach", "Réunion A", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(2, "JAN 13 2022", "14H30", "Mario", "Réunion B", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(3, "MAR 5 2022", "14H30", "Luigi", "Réunion C", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(4, "DEC 11 2021", "14H30", "Browser", "Réunion D", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(5, "JUN 15 2022", "14H30", "Peach", "Réunion E", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(6, "AUG 25 2022", "14H30", "Mario", "Réunion F", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(7, "JUL 2 2022", "14H30", "Luigi", "Réunion G", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(8, "AUG 11 2022", "14H30", "Browser", "Réunion H", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(9, "APR 18 2022", "14H30", "Peach", "Réunion I", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com"),
            new Reunion(10, "SEP 12 2022", "14H30", "Mario", "Réunion J", "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com")
    );

    static List<Reunion> generateReunions() {
        return new ArrayList<>(DUMMY_REUNIONS);
    }

    protected ReunionModel() {

        int id = 1;
        String date = "AUG 25 2022";
        String time = "14H30";
        String location = "Peach";
        String subject = "Réunion A";
        String attendees = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion1 = new Reunion(id, date, time, location, subject, attendees);
        reunions.add(reunion1);

        int id2 = 2;
        String date2 = "JAN 13 2022";
        String time2 = "14H30";
        String location2 = "Mario";
        String subject2 = "Réunion B";
        String attendees2 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion2 = new Reunion(id2, date2, time2, location2, subject2, attendees2);
        reunions.add(reunion2);

        int id3 = 3;
        String date3 = "MAR 5 2022";
        String time3 = "14H30";
        String location3 = "Luigi";
        String subject3 = "Réunion C";
        String attendees3 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion3 = new Reunion(id3, date3, time3, location3, subject3, attendees3);
        reunions.add(reunion3);

        int id4 = 4;
        String date4 = "DEC 11 2021";
        String time4 = "14H30";
        String location4 = "Browser";
        String subject4 = "Réunion D";
        String attendees4 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion4 = new Reunion(id4, date4, time4, location4, subject4, attendees4);
        reunions.add(reunion4);

        int id5 = 5;
        String date5 = "JUN 15 2022";
        String time5 = "14H30";
        String location5 = "Peach";
        String subject5 = "Réunion E";
        String attendees5 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion5 = new Reunion(id5, date5, time5, location5, subject5, attendees5);
        reunions.add(reunion5);

        int id6 = 6;
        String date6 = "AUG 25 2022";
        String time6 = "14H30";
        String location6 = "Mario";
        String subject6 = "Réunion F";
        String attendees6 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion6 = new Reunion(id6, date6, time6, location6, subject6, attendees6);
        reunions.add(reunion6);

        int id7 = 7;
        String date7 = "JUL 2 2022";
        String time7 = "14H30";
        String location7 = "Luigi";
        String subject7 = "Réunion G";
        String attendees7 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion7 = new Reunion(id7, date7, time7, location7, subject7, attendees7);
        reunions.add(reunion7);

        int id8 = 8;
        String date8 = "AUG 11 2022";
        String time8 = "14H30";
        String location8 = "Browser";
        String subject8 = "Réunion H";
        String attendees8 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion8 = new Reunion(id8, date8, time8, location8, subject8, attendees8);
        reunions.add(reunion8);

        int id9 = 9;
        String date9 = "APR 18 2022";
        String time9 = "14H30";
        String location9 = "Peach";
        String subject9 = "Réunion I";
        String attendees9 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion9 = new Reunion(id9, date9, time9, location9, subject9, attendees9);
        reunions.add(reunion9);

        int id10 = 10;
        String date10 = "SEP 12 2022";
        String time10 = "14H30";
        String location10 = "Mario";
        String subject10 = "Réunion J";
        String attendees10 = "amandine@lamzone.com,luc@lamzone.com,maxime@lamzone.com,paul@lamzone.com";
        Reunion reunion10 = new Reunion(id10, date10, time10, location10, subject10, attendees10);
        reunions.add(reunion10);


    }

    public static ReunionModel getInstance() {
        if (instance == null) {
            instance = new ReunionModel();
        }
        return instance;
    }

    public List<Reunion> filterDateReunions(Long startDate, Long endDate) {

        //Log.v(TAG, "date de départ=" + startDate);
        //Log.v(TAG, "date de fin=" + endDate);


        List<Reunion> reunions = getReunions();
        List<Date> listDates = new ArrayList<>();
        List<String> dateStringList = new ArrayList<>();
        List<Reunion> filterDate = new ArrayList<>();

        Format format = new SimpleDateFormat("MMM dd yyyy");

        Date sDate = new Date(startDate);
        Date eDate = new Date(endDate);

        Calendar calendar = new GregorianCalendar();

        for (calendar.setTime(sDate); !sDate.after(eDate); calendar.add(Calendar.DATE, 1), sDate = calendar.getTime()) {

            listDates.add(sDate);
        }


        //Log.v(TAG, "liste de dates=" + listDates);

        for (Date date : listDates) {
            String dateStr = format.format(date);
            dateStringList.add(dateStr.toUpperCase());
        }
        //Log.v(TAG, "liste de dates format string=" + dateStringList);

        for (Reunion reunion : reunions) {

            for (int i = 0; i < dateStringList.size(); i++) {
                if (reunion.getDate().equals(dateStringList.get(i))) {
                    filterDate.add(reunion);
                }
            }
        }

        //Log.v(TAG, "liste de dates filtrées=" + filterDate);

        return filterDate;
    }


    public List<Reunion> filterReunions(String location) {
        List<Reunion> reunions = getReunions();
        List<Reunion> filterLocation = new ArrayList<>();
        for (Reunion reunion : reunions) {

            if (reunion.getLocation().equals(location)) {
                filterLocation.add(reunion);

            }
        }
        return filterLocation;
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
