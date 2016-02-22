package m4104c.tp2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private Button valider;
    private ArrayList<LineOfResult> linesOfResults;
    public static final String VERIFICATION = "verif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_table);
        linesOfResults = new ArrayList<LineOfResult>();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeId);
        generation();
        listeners();
    }

    private void generation() {
        int choosenTable = getIntent().getIntExtra(Exercice5Activity.MULTIPLE_CHOOSE, 0);

        RelativeLayout.LayoutParams lay;
        RelativeLayout.LayoutParams lay2;

        for(int i = 0; i<3; i++) {
            lay = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lay2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            TextView tv = new TextView(this);
            tv.setTextSize(25);
            tv.setText(choosenTable + " x " + i + " = ");
            tv.setId(i + 1);

            EditText editText = new EditText(this);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setId(i + 10);

            lay2.addRule(RelativeLayout.RIGHT_OF, tv.getId());
            if(i>=1) {
                lay.addRule(RelativeLayout.BELOW, i);
                lay2.addRule(RelativeLayout.BELOW, i);
            }

            tv.setLayoutParams(lay);
            editText.setLayoutParams(lay2);

            relativeLayout.addView(tv);
            relativeLayout.addView(editText);

            LineOfResult lineOfResult = new LineOfResult(tv, editText, choosenTable, i);
            this.linesOfResults.add(lineOfResult);
        }
        ajouterBoutonValider();
    }

    private void ajouterBoutonValider() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        valider = new Button(this);
        valider.setText("Valider");
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, relativeLayout.getId());
        layoutParams.addRule(RelativeLayout.BELOW, this.linesOfResults.get(this.linesOfResults.size()-1).getEditText().getId());
        valider.setLayoutParams(layoutParams);

        relativeLayout.addView(valider);
        valider.setId(30);
        Log.d("idValider", "" + valider.getId());
    }

    private void listeners() {
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, ResultatActivity.class);
                intent.putExtra(TableActivity.this.VERIFICATION, TableActivity.this.verification());
                startActivity(intent);
            }
        });
    }

    public boolean verification() {
        for(LineOfResult l : this.linesOfResults) {
            if(l.getEditText().getText().toString().isEmpty()
                    || !l.getEditText().getText().toString().isEmpty() && !l.isTrue()) {
                Log.d("Valeur", "Faux");
                return false;
            }
            Log.d("Valeur", "Juste");
        }
        return true;
    }
}
