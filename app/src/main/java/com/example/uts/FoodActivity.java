package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    ArrayList<Drink> foodlistArray;
    RecyclerView fooditem;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        fooditem = findViewById(R.id.fooditem);
        fooditem.setLayoutManager(new LinearLayoutManager(this));

        foodlistArray = new ArrayList<>();
        Drink listfood1 = new Drink();
        listfood1.drink_name = "Mie";
        listfood1.price = 7000;
        listfood1.drinkImage = R.drawable.mie;
        Drink listfood2 = new Drink();
        listfood2.drink_name = "Sop kambing";
        listfood2.price = 27000;
        listfood2.drinkImage = R.drawable.sopkambing;
        Drink listfood3 = new Drink();
        listfood3.drink_name = "Sop ayam";
        listfood3.price = 17000;
        listfood3.drinkImage = R.drawable.sopayam;
        Drink listfood4 = new Drink();
        listfood4.drink_name = "Nasi goreng";
        listfood4.price = 15000;
        listfood4.drinkImage = R.drawable.nasgor;
        Drink listfood5 = new Drink();
        listfood5.drink_name = "Kepiting";
        listfood5.price = 55000;
        listfood5.drinkImage = R.drawable.kepiting;
        Drink listfood6 = new Drink();
        listfood6.drink_name = "Sate";
        listfood6.price = 20000;
        listfood6.drinkImage = R.drawable.sate;
        Drink listfood7 = new Drink();
        listfood7.drink_name = "Iga";
        listfood7.price = 45000;
        listfood7.drinkImage = R.drawable.iga;
        Drink listfood8 = new Drink();
        listfood8.drink_name = "Ikan";
        listfood8.price = 30000;
        listfood8.drinkImage = R.drawable.ikan;


        foodlistArray.add(listfood1);
        foodlistArray.add(listfood2);
        foodlistArray.add(listfood3);
        foodlistArray.add(listfood4);
        foodlistArray.add(listfood5);
        foodlistArray.add(listfood6);
        foodlistArray.add(listfood7);
        foodlistArray.add(listfood8);
//        Toast.makeText(this,listfood1.drink_name,Toast.LENGTH_SHORT).show();

        adapter = new FoodAdapter(this, foodlistArray);
        fooditem.setAdapter(adapter);
    }

    public void foodgobackmenu(View view) {
        Intent gotbackmenu = new Intent(this, MainActivity.class);
        startActivity(gotbackmenu);
    }

    public void gotomyorder(View view) {
        Intent gotbackmenu = new Intent(this, OrderedActivity.class);
        startActivity(gotbackmenu);
    }
}