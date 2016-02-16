package m4104c.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Exercice4Activity extends AppCompatActivity {
    public final static int EXERCICE_4_HELLO_REQUEST = 0;
    public static final String NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);
    }


    public void onValiderButton(View view) {
        EditText editNom = (EditText) this.findViewById(R.id.editTextNom);
        Intent newAct = new Intent(this, HelloActivity.class);
        newAct.putExtra(this.NAME, editNom.getText().toString());
        this.startActivityForResult(newAct, EXERCICE_4_HELLO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == EXERCICE_4_HELLO_REQUEST) {
            String notification = "Retour à exercice4";
            Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();
        }
    }
}
