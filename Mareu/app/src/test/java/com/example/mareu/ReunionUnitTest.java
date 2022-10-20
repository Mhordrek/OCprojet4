package com.example.mareu;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.*;

import android.util.Log;

import com.example.mareu.Base.Mvp;
import com.example.mareu.Features.AddReunion.AddReunionPresenter;
import com.example.mareu.Features.Reunions.Mareu;
import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.Features.Reunions.ReunionModel;
import com.example.mareu.Features.Reunions.ReunionPresenter;
import com.example.mareu.Model.Reunion;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ReunionUnitTest {
    

    @Test
    public void getReunionsWithSuccess() {

        List<Reunion> reunions = ReunionModel.getInstance().getReunions();
        Reunion[] reunionsArray = new Reunion[reunions.size()];
        reunionsArray = reunions.toArray(reunionsArray);
        List<Reunion> expectedReunions = ReunionModel.DUMMY_REUNIONS;
        Reunion[] expectedReunionsArray = new Reunion[expectedReunions.size()];
        expectedReunionsArray = reunions.toArray(expectedReunionsArray);
        assertArrayEquals(reunionsArray,expectedReunionsArray);
    }

    @Test
    public void DeleteReunionWithSuccess() {
        Reunion reunionToDelete = ReunionModel.getInstance().getReunions().get(0);
        ReunionModel.getInstance().removeReunion(reunionToDelete);
        assertFalse(ReunionModel.getInstance().getReunions().contains(reunionToDelete));

    }

   @Test
    public void AddReunionWithSuccess() {
        Reunion reunion = new Reunion(11, "SEP 02 2022","14h30", "Mario", "Reunion d'information", "alain@lamzone.com");
        ReunionModel.getInstance().addReunion(reunion);
        assertTrue(ReunionModel.getInstance().getReunions().contains(reunion));

    }

    @Test
    public void filterReunionLocation() {
        // il y a par défaut 2 réunions dont la location est Luigi dans notre liste

        Reunion reunion = new Reunion(12,"SEP 21 2022","14h30","Luigi","Réunion test","herve@lamzone.com");
        ReunionModel.getInstance().addReunion(reunion);
        assertTrue(ReunionModel.getInstance().getReunions().contains(reunion));
        List<Reunion> filteredLocationReunion = ReunionModel.getInstance().filterReunions("Luigi");
        assertTrue(filteredLocationReunion.size() == 3);
        for(Reunion r: filteredLocationReunion){
            assertEquals(r.getLocation().toString(),"Luigi");
        }


    }

    @Test
    public void filterReunionDate() {

        //startDate = SEP 9 2022
        //endDate = SEP 11 2022

        String filterDate = "SEP 10 2022";

        long startDate = 1662681600000L;
        long endDate = 1662854400000L;


        Reunion reunion = new Reunion(13,"SEP 10 2022","14h30","Browser","Réunion evaluation","thierry@lamzone.com");
        ReunionModel.getInstance().addReunion(reunion);
        List<Reunion> filteredDateReunion = ReunionModel.getInstance().filterDateReunions(startDate,endDate);
        for(Reunion r:filteredDateReunion){
            assertEquals(r.getDate().toString(),filterDate);
        }

    }



}