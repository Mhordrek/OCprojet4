package com.example.mareu.Features.Reunions;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.mareu.Features.AddReunion.AddReunion;
import com.example.mareu.Utils.MareuRecyclerViewAdapter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ReunionActivityList extends AppCompatActivity implements Mareu.View { RecyclerView list;
    MareuRecyclerViewAdapter adapter;

    private ReunionPresenter mPresenter;
    private Toolbar mToolbar;
    FloatingActionButton mFloatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion_list);
        mPresenter = new ReunionPresenter(this);
        list=(RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Reunion> reunions = mPresenter.loadReunions();
        showReunions(reunions);
        mFloatingActionButton = findViewById(R.id.floatingActionButton);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabintent = new Intent(getApplicationContext(),AddReunion.class);
                startActivity(fabintent);
            }
        });


    }


    @Override
    public void showReunions(List<Reunion> reunions) {

        adapter=new MareuRecyclerViewAdapter(reunions);
        list.setAdapter(adapter);

    }





}