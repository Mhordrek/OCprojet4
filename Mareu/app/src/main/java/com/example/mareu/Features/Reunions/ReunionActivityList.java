package com.example.mareu.Features.Reunions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.mareu.Features.AddReunion.AddReunionActivity;
import com.example.mareu.Utils.MareuRecyclerViewAdapter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.List;

public class ReunionActivityList extends AppCompatActivity implements Mareu.View { RecyclerView list;
    MareuRecyclerViewAdapter adapter;

    private ReunionPresenter mPresenter;
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
                Intent fabIntent = new Intent(getApplicationContext(), AddReunionActivity.class);
                startActivity(fabIntent);
            }
        });




    }


    @Override
    public void showReunions(List<Reunion> reunions) {

        adapter=new MareuRecyclerViewAdapter(reunions);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter_button,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){


            case R.id.filter_button_date: item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    return false;
                }
            });

            case R.id.filter_button_location: item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    return false;
                }
            });


        }
        return(super.onOptionsItemSelected(item));
    }





}