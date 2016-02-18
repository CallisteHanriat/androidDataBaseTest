package m4104c.tp2;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private ArrayList<TextView> textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_table);
        relativeLayout = new RelativeLayout(this);
        textViews = new ArrayList<TextView>();
        generation();
        this.setContentView(relativeLayout);
    }

    public void generation() {
        TextView tv = new TextView(this);
        TextView tv2 = new TextView(this);

        tv.setText("tv1");
        tv2.setText("tv2");

        RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeLayout.addView(tv, lay);
        lay.addRule(RelativeLayout.RIGHT_OF, tv.getId());
        relativeLayout.addView(tv2, lay);
    }
}
