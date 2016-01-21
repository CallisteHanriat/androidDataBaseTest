package com.example.couim.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView listPerson;
    private Adapter adapter;
    private ArrayList<Person> allPersons;
    private ArrayList<Person> allPersonTest;
    private PersonDAO personDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        this.personDAO = new PersonDAO(this.getApplicationContext());
        this.personDAO.open();

        update();

        allPersonTest = new ArrayList<Person>();
        allPersonTest.add(new Person("Sebastien", "Patrick"));
        allPersonTest.add(new Person("Lagneux", "Nicolas"));
        allPersonTest.add(new Person("LightFoot", "David"));
        allPersonTest.add(new Person("Culet", "Annie"));
        allPersonTest.add(new Person("Saugnier", "Valentin"));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id==R.id.action_drop) {
            dropDb();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void dropDb() {
        if(personDAO.deleteAllPersonDB()) {
            Toast.makeText(getApplicationContext(), "dataBase Deleted", Toast.LENGTH_SHORT).show();
            update();
        }
    }

    public void update() {
        this.allPersons = this.personDAO.findAllPersons();

        if(this.allPersons == null) {
            Toast.makeText(getApplicationContext(), "dataBase empty", Toast.LENGTH_SHORT).show();
            this.allPersons = new ArrayList<Person>();
        }

        this.adapter = new Adapter(getBaseContext(), this.allPersons);
        this.listPerson = (ListView) findViewById(R.id.list_person);
        this.listPerson.setAdapter(this.adapter);

    }

    @Override
    protected void onResume() {
        this.personDAO.open();
        update();
        super.onResume();
    }

    @Override
    protected void onPause() {
        this.personDAO.close();
        super.onPause();
    }
}
