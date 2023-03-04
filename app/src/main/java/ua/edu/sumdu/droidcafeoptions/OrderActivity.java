package ua.edu.sumdu.droidcafeoptions;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class OrderActivity extends AppCompatActivity {

    Button mBtnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);

        mBtnDate = findViewById(R.id.btn_date);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        mBtnDate.setVisibility(
                view.getId() == R.id.pickup && checked
                        ? View.VISIBLE
                        : View.INVISIBLE
        );
    }

    public void OnSelectDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(
                this,
                (DatePickerDialog.OnDateSetListener) (picker, y, m, d) ->
                        displayToast(getString(R.string.picked_date, d, m, y)),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    public void displayToast(String message) {
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }
}