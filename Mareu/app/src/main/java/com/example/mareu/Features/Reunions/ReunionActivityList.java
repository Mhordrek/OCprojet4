package com.example.mareu.Features.Reunions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mareu.Features.AddReunion.AddReunionActivity;
import com.example.mareu.Utils.Event.DeleteReunionEvent;
import com.example.mareu.Utils.MareuRecyclerViewAdapter;
import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;
import java.util.List;

public class ReunionActivityList extends AppCompatActivity implements Mareu.View { RecyclerView list;

    private MareuRecyclerViewAdapter adapter;
    private ReunionPresenter mPresenter;
    private FloatingActionButton mFloatingActionButton;
    private Button locationFilterButton;





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
    void showLocationDialog(){

        final Dialog dialog = new Dialog(ReunionActivityList.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.location_filter_dialog);

        final TextView enterName = dialog.findViewById(R.id.entername);
        final EditText fullName = dialog.findViewById(R.id.editText_fullName);
        Button ok = dialog.findViewById(R.id.button_ok);
        Button cancel = dialog.findViewById(R.id.button_cancel);
        dialog.show();

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
                    showLocationDialog();
                    return true;
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
    public void onDeleteReunion(DeleteReunionEvent event){

        mPresenter.removeReunion(event.reunion);
        initList();
    }




}