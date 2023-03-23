package com.nihalramtripathi.analytics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.nihalramtripathi.analytics.recyclarStudents.PositionModel;
import com.nihalramtripathi.analytics.recyclarStudents.StudentsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity {
    TextView accuracy, status, health;
    PieChart pieChart;
    RecyclerView recyclerView;
    ArrayList<PositionModel> arrayList= new ArrayList<>();
    ConstraintLayout healthL , statusL, accuracyL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samsung_galaaxy_s10_3);
        getSupportActionBar().hide();





        accuracy = findViewById(R.id.txt_accuracy);
        status = findViewById(R.id.txt_status);
        health = findViewById(R.id.txt_health);
        pieChart = findViewById(R.id.pieChart_view);
        recyclerView=findViewById(R.id.recyclarView);
        healthL=findViewById(R.id.healthL);
        statusL=findViewById(R.id.statusL);
        accuracyL=findViewById(R.id.accuracyL);

        showPieChart();

        arrayList.add(new PositionModel("Rajit","1st"));
        arrayList.add(new PositionModel("Devashish","2st"));
        arrayList.add(new PositionModel("Yogita","3st"));
        arrayList.add(new PositionModel("Ankur","4st"));
        arrayList.add(new PositionModel("Ankur","5st"));
        arrayList.add(new PositionModel("Ankur","6st"));
        arrayList.add(new PositionModel("Ankur","7st"));
        arrayList.add(new PositionModel("Ankur","8st"));
        arrayList.add(new PositionModel("Ankur","8st"));
        arrayList.add(new PositionModel("Ankur","8st"));
        arrayList.add(new PositionModel("Ankur","8st"));

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        StudentsAdapter adapter= new StudentsAdapter(getApplicationContext(),arrayList);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        accuracyL.setVisibility(View.VISIBLE);
        statusL.setVisibility(View.GONE);
        healthL.setVisibility(View.GONE);

//        AccuracyFragment accuracyfragment = new AccuracyFragment();
//        StatusFragment statusfragment = new StatusFragment();
//        HealthFragment healthfragment = new HealthFragment();
//
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, accuracyfragment)
//                .setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
//                addToBackStack(null).
//                commit();


        accuracy.setTextColor(getResources().getColor(R.color.white));
        accuracy.setBackgroundResource(R.drawable.click_bg_txt);


        accuracy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.frameLayout, accuracyfragment).
//                        setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
//                        addToBackStack(null).
//                        commit();
                accuracyL.setVisibility(View.VISIBLE);
                statusL.setVisibility(View.GONE);
                healthL.setVisibility(View.GONE);

                accuracy.setTextColor(getResources().getColor(R.color.white));
                accuracy.setBackgroundResource(R.drawable.click_bg_txt);

                status.setTextColor(getResources().getColor(R.color.silver));
                status.setBackgroundResource(R.drawable.txt_gradient_background);

                health.setTextColor(getResources().getColor(R.color.silver));
                health.setBackgroundResource(R.drawable.txt_gradient_background);

            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                accuracyL.setVisibility(View.GONE);
                statusL.setVisibility(View.VISIBLE);
                healthL.setVisibility(View.GONE);
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.frameLayout, statusfragment).
//                        setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
//                        addToBackStack(null).
//                        commit();
                status.setTextColor(getResources().getColor(R.color.white));
                status.setBackgroundResource(R.drawable.click_bg_txt);

                health.setTextColor(getResources().getColor(R.color.silver));
                health.setBackgroundResource(R.drawable.txt_gradient_background);

                accuracy.setTextColor(getResources().getColor(R.color.silver));
                accuracy.setBackgroundResource(R.drawable.txt_gradient_background);

            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                accuracyL.setVisibility(View.GONE);
                statusL.setVisibility(View.GONE);
                healthL.setVisibility(View.VISIBLE);
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.frameLayout, healthfragment).
//                        setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
//                        addToBackStack(null).
//                        commit();
                health.setTextColor(getResources().getColor(R.color.white));
                health.setBackgroundResource(R.drawable.click_bg_txt);

                accuracy.setTextColor(getResources().getColor(R.color.silver));
                accuracy.setBackgroundResource(R.drawable.txt_gradient_background);


                status.setTextColor(getResources().getColor(R.color.silver));
                status.setBackgroundResource(R.drawable.txt_gradient_background);
            }
        });


    }

    private void showPieChart(){

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        String label = "type";

        //initializing data
        Map<String, Integer> typeAmountMap = new HashMap<>();
        typeAmountMap.put("Strong",200);
        typeAmountMap.put("Weak",230);
        typeAmountMap.put("On The Edge",100);
        //typeAmountMap.put("Stationary",500);
       // typeAmountMap.put("Phone",50);

        //initializing colors for the entries
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#EE3560"));
        colors.add(Color.parseColor("#00FFCD"));
        colors.add(Color.parseColor("#476567"));
        colors.add(Color.parseColor("#890567"));
        colors.add(Color.parseColor("#a35567"));
        colors.add(Color.parseColor("#ff5f67"));
        colors.add(Color.parseColor("#707070"));

        //input data and fit data into pie chart entry
        for(String type: typeAmountMap.keySet()){
            pieEntries.add(new PieEntry(typeAmountMap.get(type).floatValue(), type));
        }

        //collecting the entries with label name
       PieDataSet pieDataSet = new PieDataSet(pieEntries,label);
        //setting text size of the value
        pieDataSet.setValueTextSize(12f);
        //providing color list for coloring different entries
        pieDataSet.setColors(colors);
        //grouping the data set from entry to chart
        PieData pieData = new PieData(pieDataSet);
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true);

        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}