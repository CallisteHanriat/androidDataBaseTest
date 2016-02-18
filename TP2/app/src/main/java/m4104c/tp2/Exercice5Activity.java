package m4104c.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;


public class Exercice5Activity extends AppCompatActivity {

    public static final String MULTIPLE_CHOOSE = "table_choisie";
    private NumberPicker numberPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);

        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(9);
    }

    public void onValiderButton(View view) {
        int tableChoosen = numberPicker.getValue();
        Intent intent = new Intent(this, TableActivity.class);
        intent.putExtra(MULTIPLE_CHOOSE, tableChoosen);
        startActivity(intent);
    }
}
