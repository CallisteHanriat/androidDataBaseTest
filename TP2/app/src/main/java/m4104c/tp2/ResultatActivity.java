package m4104c.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultatActivity extends AppCompatActivity {
    private boolean aFaitJuste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        this.aFaitJuste = getIntent().getBooleanExtra(TableActivity.VERIFICATION, false);
        generation();
    }

    private void generation() {
        TextView tv = (TextView) findViewById(R.id.textResultMultiplicationTable);
        Button button = (Button) findViewById(R.id.buttonRetour);
        if (this.aFaitJuste) {
            tv.setText("Felicitations !");
            button.setText("Retour à l'exercice");
        } else {
            tv.setText("Tu as fait une erreur");
            button.setText("Corriger l'exercice");
        }
    }

    public void actionBoutonDepart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void actionBoutonRetour(View view) {
        Intent intent;
        if (this.aFaitJuste) {
            intent = new Intent(this, Exercice5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            intent = new Intent(this, TableActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
