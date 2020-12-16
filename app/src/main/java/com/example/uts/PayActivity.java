package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PayActivity extends AppCompatActivity {
    ArrayList<itemOrdered> payedlist;
    RecyclerView payitem;
    PayAdapter adapter;
    Integer total = 0;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        payitem = findViewById(R.id.payitem);
        payitem.setLayoutManager(new LinearLayoutManager(this));

        Intent mypayedlist = getIntent();
        payedlist = (ArrayList<itemOrdered>) getIntent().getSerializableExtra("listdatapay");

        for (int u = 0; u < payedlist.size();u++) {
            total += payedlist.get(u).getOrdered_price() * payedlist.get(u).getOrdered_qty();
        }


        Toast.makeText(this,String.valueOf(total), Toast.LENGTH_SHORT).show();
        tvTotal = (TextView) findViewById(R.id.totalhargaz);
        tvTotal.setText(String.valueOf(total));


        adapter = new PayAdapter(this, payedlist);
        payitem.setAdapter(adapter);

    }

    public void gomain(View view) {
        Intent gomainmenu = new Intent(this, MainActivity.class);
        recreate();
        startActivity(gomainmenu);

    }

    public void backmenu(View view) {
        Intent gobackmain = new Intent(this, MainActivity.class);
        startActivity(gobackmain);
    }
}