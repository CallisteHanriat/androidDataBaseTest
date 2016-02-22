package m4104c.tp2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by couim on 22/02/16.
 */
public class LineOfResult {
    private TextView lineText;
    private EditText editText;
    private int firstChiffer, secondChiffer, result;

    public LineOfResult(TextView tv_, EditText et_, int firstChiffer_, int secondChiffer_) {
        setLineText(tv_);
        setEditText(et_);
        setFirstChiffer(firstChiffer_);
        setSecondChiffer(secondChiffer_);
        setResult(getFirstChiffer() * getSecondChiffer());
    }

    public boolean isTrue() {
        Log.d("Theorical", Integer.toString(this.getFirstChiffer() * this.getSecondChiffer()));
        Log.d("Empirical", this.getEditText().getText().toString());
        return this.getFirstChiffer()*this.getSecondChiffer() == Integer.parseInt(this.getEditText().getText().toString());
    }
    public TextView getLineText() {
        return lineText;
    }

    public void setLineText(TextView lineText) {
        this.lineText = lineText;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public int getFirstChiffer() {
        return firstChiffer;
    }

    public void setFirstChiffer(int firstChiffer) {
        this.firstChiffer = firstChiffer;
    }

    public int getSecondChiffer() {
        return secondChiffer;
    }

    public void setSecondChiffer(int secondChiffer) {
        this.secondChiffer = secondChiffer;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
