package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//Aldi Nugroho 2201816796
//Mobile Programming
//LD01
public class MainActivity extends AppCompatActivity{
    TextView tvBlnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBlnce = (TextView) findViewById(R.id.showblnc);
        Intent fromtopup = getIntent();
        Integer blnc;
        Integer blnc2;


        blnc2 = fromtopup.getIntExtra("valuefromback",0);
        blnc = fromtopup.getIntExtra("topval",0);
        String cek = "blnc:"+blnc+", blnc2:"+blnc2;
//        tes perpindahan data
//        Toast.makeText(this, cek,Toast.LENGTH_SHORT).show();

        if (blnc == 0) {
            tvBlnce.setText("" + blnc2);
        } else {
            tvBlnce.setText(""+blnc);
        }




    }

    public void toDrink(View view) {
        Intent todrink = new Intent(this, DrinkActivity.class);
        startActivity(todrink);
    }

    public void tomyorderfix(View view) {
        Intent tomyorder = new Intent(this, OrderedActivity.class);

        startActivity(tomyorder);
    }

    public void gotosnack(View view) {
        Intent gotonext = new Intent(this, SnackActivity.class);
        startActivity(gotonext);
    }

    public void tofoods(View view) {
        Intent tofood = new Intent(this, FoodActivity.class);
        startActivity(tofood);
    }

    String blncmenu;
    Integer blncmenuint;
    public void topupmenu(View view) {
        Intent totopup = new Intent(this, TopupActivity.class);

        blncmenu = tvBlnce.getText().toString();
        blncmenuint = Integer.valueOf(String.valueOf(blncmenu));
        totopup.putExtra("valuefrommain", blncmenuint);

        startActivity(totopup);
    }
}