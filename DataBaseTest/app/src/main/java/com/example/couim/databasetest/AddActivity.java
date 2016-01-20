package com.example.couim.databasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by couim on 20/01/16.
 */
public class AddActivity extends AppCompatActivity {
    private Button ajoute;
    private EditText nom;
    private EditText prenom;
    private PersonDAO personDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        ajoute = (Button) this.findViewById(R.id.ajouterNoms);
        nom = (EditText) this.findViewById(R.id.editNamePerson);
        prenom = (EditText) this.findViewById(R.id.editSurNamePerson);
        personDAO = new PersonDAO(getApplicationContext());
        personDAO.open();
        ajoute.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  personDAO.insertPersonIntoDataBase(new Person(nom.getEditableText().toString(), prenom.getEditableText().toString()));
                  Toast.makeText(AddActivity.this, prenom.getEditableText().toString(), Toast.LENGTH_SHORT).show();
              }
          }

        );
    }

    @Override
    protected void onPause() {
        personDAO.close();
        super.onPause();
    }

    @Override
    protected void onResume() {
        personDAO.open();
        super.onResume();
    }
}
