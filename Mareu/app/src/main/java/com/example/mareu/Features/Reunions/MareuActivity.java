package com.example.mareu.Features.Reunions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mareu.MareuRecyclerViewAdapter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;

import java.util.List;

public class MareuActivity extends AppCompatActivity implements Mareu.View { RecyclerView list;
    MareuRecyclerViewAdapter adapter;
    private MareuPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mareu_list);
        mPresenter = new MareuPresenter(this);
        list=(RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Reunion> reunions = mPresenter.loadReunions();
        showReunions(reunions);

    }

    @Override
    public void showReunions(List<Reunion> reunions) {

        adapter=new MareuRecyclerViewAdapter(reunions);
        list.setAdapter(adapter);

    }
}