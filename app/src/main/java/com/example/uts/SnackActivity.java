package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class SnackActivity extends AppCompatActivity {

    ArrayList<Drink> snacklistArray;
    RecyclerView snackitem;
    SnackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        snackitem = findViewById(R.id.snackitem);
        snackitem.setLayoutManager(new LinearLayoutManager(this));

        snacklistArray = new ArrayList<>();
        Drink listsnack1 = new Drink();
        listsnack1.drink_name = "Snack Taro";
        listsnack1.price = 2000;
        listsnack1.drinkImage = R.drawable.taro;
        Drink listsnack2 = new Drink();
        listsnack2.drink_name = "Snack Soba";
        listsnack2.price = 1500;
        listsnack2.drinkImage = R.drawable.soba;
        Drink listsnack3 = new Drink();
        listsnack3.drink_name = "Snack Chitato";
        listsnack3.price = 3000;
        listsnack3.drinkImage = R.drawable.chita;
        Drink listsnack4 = new Drink();
        listsnack4.drink_name = "Snack JetZ";
        listsnack4.price = 3000;
        listsnack4.drinkImage = R.drawable.jetz;
        Drink listsnack5 = new Drink();
        listsnack5.drink_name = "Snack Mie Kremez";
        listsnack5.price = 2000;
        listsnack5.drinkImage = R.drawable.kremez;
        Drink listsnack6 = new Drink();
        listsnack6.drink_name = "Snack Lays";
        listsnack6.price = 2500;
        listsnack6.drinkImage = R.drawable.lays;
        Drink listsnack7 = new Drink();
        listsnack7.drink_name = "Snack Chuba";
        listsnack7.price = 1000;
        listsnack7.drinkImage = R.drawable.cuba;
        Drink listsnack8 = new Drink();
        listsnack8.drink_name = "Snack Cheetos";
        listsnack8.price = 2000;
        listsnack8.drinkImage = R.drawable.chee;
        snacklistArray.add(listsnack1);
        snacklistArray.add(listsnack2);
        snacklistArray.add(listsnack3);
        snacklistArray.add(listsnack4);
        snacklistArray.add(listsnack5);
        snacklistArray.add(listsnack6);
        snacklistArray.add(listsnack7);
        snacklistArray.add(listsnack8);
//        Toast.makeText(this,listsnack1.drink_name,Toast.LENGTH_SHORT).show();

        adapter = new SnackAdapter(this, snacklistArray);
        snackitem.setAdapter(adapter);

    }

    public void snackgobackmenu(View view) {
        Intent snackgoback = new Intent(this, MainActivity.class);
        startActivity(snackgoback);
    }

    public void gotomyorder(View view) {
        Intent gtomyorder = new Intent(this, OrderedActivity.class);
        startActivity(gtomyorder);
    }
}