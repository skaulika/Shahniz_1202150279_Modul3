package com.example.android.shahniz_1202150279_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<MineralWater> mMineralData;
    private MineralWaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the ArrayLIst that will contain the data
        mMineralData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new MineralWaterAdapter(this, mMineralData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();
    }

    /**
     * Method for initializing the mineral data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] mineralList = getResources().getStringArray(R.array.mineral_titles);
        String[] mineralInfo = getResources().getStringArray(R.array.mineral_info);
        TypedArray mineralImageResources = getResources().obtainTypedArray(R.array.mineral_images);

        //Clear the existing data (to avoid duplication)
        mMineralData.clear();

        //Create the ArrayList of mineral water objects with the titles and information about each mineral water
        for(int i=0;i<mineralList.length;i++){
            mMineralData.add(new MineralWater(mineralList[i],mineralInfo[i], mineralImageResources.getResourceId(i,0)));
        }
        //Recycle the typed array
        mineralImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
