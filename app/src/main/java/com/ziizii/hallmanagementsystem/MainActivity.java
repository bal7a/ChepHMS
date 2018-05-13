package com.ziizii.hallmanagementsystem;

import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.TimeUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ziizii.hallmanagementsystem.DataBaseManager.Day;
import com.ziizii.hallmanagementsystem.DataBaseManager.Hall;
import com.ziizii.hallmanagementsystem.DataBaseManager.Manager;
import com.ziizii.hallmanagementsystem.DataBaseManager.Slot;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner daySpinner;
    private Spinner spinner;
    private Spinner slotSpinner;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new Manager().execute("http://192.168.43.3:5000/halls/saturday","http://192.168.43.3:5000/halls/sunday","http://192.168.43.3:5000/halls/monday","http://192.168.43.3:5000/halls/tuesday","http://192.168.43.3:5000/halls/wednesday","http://192.168.43.3:5000/halls/thursday");

        admin = getIntent().getBooleanExtra("admin",false);
//        if(admin)
//            ((TextView) findViewById(R.id.guestTextView)).setText("Admin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button NOW = findViewById(R.id.NOW);

         spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter;
        List<String> list;

        list = new ArrayList<String>();
        list.add("Empty Halls");
        list.add("Courses");

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    findViewById(R.id.emptyHallsUI).setVisibility(View.VISIBLE);
                    findViewById(R.id.coursesUI).setVisibility(View.GONE);
                }
                if(i==1){

                    findViewById(R.id.emptyHallsUI).setVisibility(View.GONE);
                    findViewById(R.id.coursesUI).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        daySpinner = (Spinner) findViewById(R.id.day_spinner);
        ArrayAdapter<String> day_adapter;
        List<String> day_list;

        day_list = new ArrayList<String>();
        day_list.add("Saturday");
        day_list.add("Sunday");
        day_list.add("Monday");
        day_list.add("Tuesday");
        day_list.add("Wednesday");
        day_list.add("Thursday");
        day_adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, day_list);
        day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(day_adapter);



        slotSpinner = (Spinner) findViewById(R.id.slot_spinner);
        ArrayAdapter<String> slot_adapter;
        List<String> slot_list;

        slot_list = new ArrayList<String>();
        slot_list.add("1");
        slot_list.add("2");
        slot_list.add("3");
        slot_list.add("4");
        slot_list.add("5");
        slot_list.add("6");
        slot_list.add("8");
        slot_list.add("9");
        slot_list.add("10");
        slot_list.add("11");
        slot_list.add("12");
        slot_adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, slot_list);
        slot_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        slotSpinner.setAdapter(slot_adapter);

        NOW.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int day = Calendar.DAY_OF_WEEK;
                int hour = Calendar.MINUTE;
//
//                daySpinner.setSelection(day.getDayOfWeek().getValue());
//                if(time.isBefore(LocalTime.of(8,15))||time.isAfter(LocalTime.of(20,20)))
//                    return; //TODO ERROR MESSAGE
//                if(time.isAfter(LocalTime.of(8,15))&&time.isBefore(LocalTime.of(9,5)))
//                    slotSpinner.setSelection(0);
//                if(time.isAfter(LocalTime.of(9,5))&&time.isBefore(LocalTime.of(10,5)))
//                    slotSpinner.setSelection(1);
//                if(time.isAfter(LocalTime.of(10,5))&&time.isBefore(LocalTime.of(11,0)))
//                    slotSpinner.setSelection(2);
//                if(time.isAfter(LocalTime.of(11,0))&&time.isBefore(LocalTime.of(12,20))) //TODO BREAK EXCEPTION
//                    slotSpinner.setSelection(3);
//                if(time.isAfter(LocalTime.of(12,20))&&time.isBefore(LocalTime.of(13,15)))
//                    slotSpinner.setSelection(4);
//                if(time.isAfter(LocalTime.of(13,15))&&time.isBefore(LocalTime.of(14,10)))
//                    slotSpinner.setSelection(5);
//                if(time.isAfter(LocalTime.of(14,10))&&time.isBefore(LocalTime.of(15,5)))
//                    slotSpinner.setSelection(6);
//                if(time.isAfter(LocalTime.of(15,5))&&time.isBefore(LocalTime.of(16,20))) //TODO BREAK EXCEPTION
//                    slotSpinner.setSelection(7);
//                if(time.isAfter(LocalTime.of(16,20))&&time.isBefore(LocalTime.of(17,15)))
//                    slotSpinner.setSelection(8);
//                if(time.isAfter(LocalTime.of(17,15))&&time.isBefore(LocalTime.of(18,5)))
//                    slotSpinner.setSelection(9);
//                if(time.isAfter(LocalTime.of(18,10))&&time.isBefore(LocalTime.of(19,5)))
//                    slotSpinner.setSelection(10);
//                if(time.isAfter(LocalTime.of(19,5))&&time.isBefore(LocalTime.of(19,55)))
//                    slotSpinner.setSelection(11);
            }
        });



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        FloatingActionButton searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList <Hall> emptySlots = new ArrayList<>();
                if(spinner.getSelectedItemPosition()==0){
//                    Search.test();
                  int dayNo = daySpinner.getSelectedItemPosition();
                  int slotNo = daySpinner.getSelectedItemPosition();
                  Search.searchByDayAndSlot(dayNo,slotNo);
                  emptySlots=Search.getEmptyHalls();

                }
                else if(spinner.getSelectedItemPosition()==1){
                        String courseCode = ((TextView) findViewById(R.id.courseCodeTextView)).getText().toString();
                        Search.searchByCourse(courseCode);
                     emptySlots = Search.getEmptyHalls();
                }
                Intent intent = new Intent(MainActivity.this,ResultsActivity.class);
                intent.putExtra("emptySlots",emptySlots);
                intent.putExtra("admin",admin);
                startActivity(intent);



            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



     if (id == R.id.nav_send) {
         Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                 "mailto","chep@eng.asu.edu.com", null));
         emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Report message");
         startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
