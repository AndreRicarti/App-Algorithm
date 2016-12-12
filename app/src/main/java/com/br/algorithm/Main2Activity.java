package com.br.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlgorithmAdapter adapter;
    private List<Algorithm> algorithmsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        algorithmsList = new ArrayList<>();
        adapter = new AlgorithmAdapter(this, algorithmsList);

        recyclerView.setAdapter(adapter);

        prepareAlgorithms();
    }

    private void prepareAlgorithms  () {

        Algorithm algorithm = new Algorithm("Insertion Sort", "Ordenação", "C");
        algorithmsList.add(algorithm);

        Algorithm algorithm1 = new Algorithm("Selection Sort", "Ordenação", "C");
        algorithmsList.add(algorithm1);

        Algorithm algorithm2 =  new Algorithm("Bubble Sort", "Ordenação", "C");
        algorithmsList.add(algorithm2);

        adapter.notifyDataSetChanged();
    }

}