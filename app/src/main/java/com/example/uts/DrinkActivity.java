package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {

    ArrayList<Drink> drinklistArray;
    RecyclerView drinkitem;
    DrinkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);


        drinkitem = findViewById(R.id.drinkitem);
        drinkitem.setLayoutManager(new LinearLayoutManager(this));

        drinklistArray = new ArrayList<>();
        Drink listdrink1 = new Drink();
        listdrink1.drink_name = "Air Mineral";
        listdrink1.price = 5000;
        listdrink1.drinkImage = R.drawable.airmineral;

        Drink listdrink2 = new Drink();
        listdrink2.drink_name = "Jus Apel";
        listdrink2.price = 8000;
        listdrink2.drinkImage = R.drawable.apel;

        Drink listdrink3 = new Drink();
        listdrink3.drink_name = "Jus Mangga";
        listdrink3.price = 8000;
        listdrink3.drinkImage = R.drawable.mangga;

        Drink listdrink4 = new Drink();
        listdrink4.drink_name = "Jus Semangka";
        listdrink4.price = 8000;
        listdrink4.drinkImage = R.drawable.semangka;

        Drink listdrink5 = new Drink();
        listdrink5.drink_name = "Jus Alpukat";
        listdrink5.price = 8000;
        listdrink5.drinkImage = R.drawable.alpukat;

        Drink listdrink6 = new Drink();
        listdrink6.drink_name = "Jus Lemon";
        listdrink6.price = 8000;
        listdrink6.drinkImage = R.drawable.lemon;

        Drink listdrink7 = new Drink();
        listdrink7.drink_name = "Jus Melon";
        listdrink7.price = 8000;
        listdrink7.drinkImage = R.drawable.melon;

        Drink listdrink8 = new Drink();
        listdrink8.drink_name = "Jus jambu";
        listdrink8.price = 8000;
        listdrink8.drinkImage = R.drawable.jambu;

        drinklistArray.add(listdrink1);
        drinklistArray.add(listdrink2);
        drinklistArray.add(listdrink3);
        drinklistArray.add(listdrink4);
        drinklistArray.add(listdrink5);
        drinklistArray.add(listdrink6);
        drinklistArray.add(listdrink7);
        drinklistArray.add(listdrink8);

        adapter = new DrinkAdapter(this, drinklistArray);
        drinkitem.setAdapter(adapter);
    }

    public void gobackmenu(View view) {

        Intent gobackmenu = new Intent(this, MainActivity.class);
        startActivity(gobackmenu);
    }

    public void gotomyorder(View view) {
        Intent gotomyorder = new Intent(this, OrderedActivity.class);
        startActivity(gotomyorder);
    }

    public void snackgobackmenu(View view) {
        Intent snackgoback = new Intent(this, MainActivity.class);
        startActivity(snackgoback);
    }
}