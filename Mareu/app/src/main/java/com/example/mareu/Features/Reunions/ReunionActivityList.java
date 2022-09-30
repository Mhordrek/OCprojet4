package com.example.mareu.Features.Reunions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.mareu.Features.AddReunion.AddReunionActivity;
import com.example.mareu.Features.ReunionFilter.FilterDateDialogFragment;
import com.example.mareu.Features.ReunionFilter.FilterLocationDialogFragment;
import com.example.mareu.Utils.Event.DeleteReunionEvent;
import com.example.mareu.Utils.Adapter.MareuRecyclerViewAdapter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class ReunionActivityList extends AppCompatActivity implements Mareu.View {
    RecyclerView list;

    private MareuRecyclerViewAdapter adapter;
    private ReunionPresenter mPresenter;
    private FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion_list);
        mPresenter = new ReunionPresenter(this);
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Reunion> reunions = mPresenter.loadReunions();
        showReunions(reunions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.filter_toolbar);
        setSupportActionBar(toolbar);


        mFloatingActionButton = findViewById(R.id.floatingActionButton);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabIntent = new Intent(getApplicationContext(), AddReunionActivity.class);
                startActivity(fabIntent);
            }
        });


    }


    @Override
    public void showReunions(List<Reunion> reunions) {

        adapter = new MareuRecyclerViewAdapter(reunions);
        list.setAdapter(adapter);

    }

    @Override
    public void filterLocation(String location) {
        List<Reunion> reunions =  mPresenter.filterLocation(location);
        showReunions(reunions);
    }

    @Override
    public void filterDate(Long startDate, Long endDate) {
        List<Reunion> reunions = mPresenter.filterDate(startDate,endDate);
        showReunions(reunions);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("test", "test");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("test", "test");
        switch (item.getItemId()) {


            case R.id.filter_button_date:

                Log.d("date", "showdate");
                showDateDialog();
                return true;

            case R.id.filter_button_location:

                Log.d("location", "showlocation");
                showLocationDialog();
                return true;


            default:
                return (super.onOptionsItemSelected(item));
        }

    }

    private void showDateDialog() {

        FragmentManager fmDate = getSupportFragmentManager();

        FilterDateDialogFragment filterDateDialogFragment = FilterDateDialogFragment.newInstance("Choisissez une date");

        filterDateDialogFragment.show(fmDate, "fragment_edit_name");

    }

    private void showLocationDialog() {

        FragmentManager fmLocation = getSupportFragmentManager();

        FilterLocationDialogFragment filterLocationDialogFragment = FilterLocationDialogFragment.newInstance("Choisissez une salle");

        filterLocationDialogFragment.show(fmLocation, "fragment_edit_name");

    }


    private void initList() {

        List<Reunion> reunions = mPresenter.loadReunions();
        showReunions(reunions);

    }


    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onDeleteReunion(DeleteReunionEvent event) {

        mPresenter.removeReunion(event.reunion);
        initList();
    }

}



