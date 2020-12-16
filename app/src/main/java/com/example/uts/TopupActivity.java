package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TopupActivity extends AppCompatActivity {
    TextView tvBlnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        tvBlnce = (TextView) findViewById(R.id.displval);
        Intent fromtopup = getIntent();
        Integer blnc;
        blnc = fromtopup.getIntExtra("valuefrommain",0);
        tvBlnce.setText(""+blnc);

    }

    TextView tvDspl;
    EditText etVal;
    Integer etValcot;
    String etValstr;
    public void toppupp(View view) {
        tvDspl = (TextView) findViewById(R.id.displval);

        etVal = (EditText) findViewById(R.id.valutop);
        etValstr = etVal.getText().toString();
//        Toast.makeText(this, etValstr,Toast.LENGTH_SHORT).show();
        if (etValstr.matches("[0-9]+")){
            if (etValstr.equals("")){
                Toast.makeText(this, "Please input value",Toast.LENGTH_SHORT).show();
            } else {
                etValcot = Integer.valueOf(String.valueOf(etValstr));
                tvDspl.setText(""+etValcot);

                Intent valTomain = new Intent(this, MainActivity.class);
                valTomain.putExtra("topval", etValcot);
                startActivity(valTomain);
            }
//        Toast.makeText(this, String.valueOf(etValcot),Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Please input value",Toast.LENGTH_SHORT).show();
        }

    }

    String tesInt;
    Integer tesin;
    public void backmenu(View view) {
        tvDspl = (TextView) findViewById(R.id.displval);
        tesInt = tvDspl.getText().toString();
        Toast.makeText(this, tesInt,Toast.LENGTH_SHORT).show();
        tesin = Integer.valueOf(String.valueOf(tesInt));
        Intent tomenuusingback = new Intent(this, MainActivity.class);
        tomenuusingback.putExtra("valuefromback", tesin);
//        if (tesin == 0) {
//            tomenuusingback.putExtra("valuefromback", tesin);
//        } else {
//            tomenuusingback.putExtra("valuefromback", tesin);
//        }
        startActivity(tomenuusingback);

    }
}