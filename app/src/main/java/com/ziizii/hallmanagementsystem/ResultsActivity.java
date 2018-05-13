package com.ziizii.hallmanagementsystem;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ziizii.hallmanagementsystem.DataBaseManager.Hall;
import com.ziizii.hallmanagementsystem.DataBaseManager.Slot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ResultsActivity extends AppCompatActivity {
    private boolean admin;
    ArrayList<Hall> viewSlots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        admin = getIntent().getBooleanExtra("admin",false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //ArrayList<Slot> test = new ArrayList<>(Arrays.asList("931","901","914<33"));
        viewSlots=  getIntent().getParcelableArrayListExtra("emptySlots");
        final ListView resultsListView = findViewById(R.id.resultsListView);
        ArrayAdapter<Hall> arrayAdapter = new ArrayAdapter<Hall>(
                this,
                android.R.layout.simple_list_item_1,
                viewSlots
        );
        resultsListView.setAdapter(arrayAdapter);
        if (admin) {
            resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(0xFFFD99BB );
                view.invalidate();
                }
            });
        }
    }
}
