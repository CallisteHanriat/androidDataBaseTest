package m4104c.tp2;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    private ArrayList<TextView> textViews;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_table);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeId);
        textViews = new ArrayList<TextView>();
        generation();

    }

    public void generation() {
        int choosenTable = getIntent().getIntExtra(Exercice5Activity.MULTIPLE_CHOOSE, 0);
        Log.d("val", "" + choosenTable);

        RelativeLayout.LayoutParams lay;
        RelativeLayout.LayoutParams lay2;

        for(int i = 0; i<10; i++) {
            lay = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
            lay2 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            TextView tv = new TextView(this);
            EditText editText = new EditText(this);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            tv.setText(choosenTable + " x " + i + " = ");
            tv.setId(i + 1);
            lay2.addRule(RelativeLayout.RIGHT_OF, tv.getId());
            if(i>=1) {
                lay.addRule(RelativeLayout.BELOW, i);
                lay2.addRule(RelativeLayout.BELOW, i);
            }
            tv.setTextSize(25);
            tv.setLayoutParams(lay);
            editText.setLayoutParams(lay2);
            relativeLayout.addView(tv);

            relativeLayout.addView(editText);
        }
    }
}
