package com.rodrigopetito.pets.view.activity;

import android.content.Intent;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.rodrigopetito.pets.R;
import com.rodrigopetito.pets.adapter.PetAdapter;
import com.rodrigopetito.pets.controller.PetsController;
import com.rodrigopetito.pets.model.Pet;
import com.rodrigopetito.pets.util.ListItemClickListener;
import com.rodrigopetito.pets.util.RequestListener;
import com.rodrigopetito.pets.util.StringUtil;

import java.util.List;

public class MainActivity extends BaseActivity implements ListItemClickListener<Pet> {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getPetsList();

    }



    private void initViews() {

        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerView);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progressBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.activity_main_toolbar_title);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

    }


    private void getPetsList() {

        PetsController<List<Pet>> controller = new PetsController<>(this);
        setActualController(controller);
        controller.getPetsList(new RequestListener<List<Pet>>() {
            @Override
            public void onSuccess(List<Pet> result) {
                PetAdapter adapter = new PetAdapter(MainActivity.this, result);
                recyclerView.setAdapter(adapter);
                adapter.setListItemClickListener(MainActivity.this);
                showList();
            }

            @Override
            public void onError(String error) {
                showList();
            }
        });

    }


    private void showList() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


    @Override
    public void onItemClick(Pet item, Integer position) {
        Intent intent = new Intent(this, PetDetailActivity.class);
        intent.putExtra(StringUtil.PET_ID_INTENT, item.getId());
        startActivity(intent);
    }


}
