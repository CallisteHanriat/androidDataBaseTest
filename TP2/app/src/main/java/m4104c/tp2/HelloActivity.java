package m4104c.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        String nom = this.getIntent().getStringExtra(Exercice4Activity.NAME);
        TextView textView = (TextView) this.findViewById(R.id.textResult);
        textView.setText(textView.getText().toString() + " " + nom);
    }

    public void onChangerPrenomClick(View view) {
        setResult(RESULT_OK);
        super.finish();
    }

    public void onFaireAutreExoClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
