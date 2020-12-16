package com.example.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;

public class OrderedActivity extends AppCompatActivity {

    public static ArrayList<itemOrdered> listordereditem = new ArrayList<>();
    public static Integer totalharga = 0;
//    ArrayList<itemOrdered> listordereditemfix;
    RecyclerView ordereditem;
    MyorderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered);

        ordereditem = findViewById(R.id.myorderitem);
        ordereditem.setLayoutManager(new LinearLayoutManager(this));

        Intent dataitem = getIntent();
        String namaaa = dataitem.getStringExtra("namee");
        String pricee = dataitem.getStringExtra("pricee");
        String qtyy = dataitem.getStringExtra("qtyy");


        Integer fixqty = 0;
        Integer fixprice = 0;
        Integer tempqty = 0;
        try {
             fixqty = Integer.valueOf(String.valueOf(qtyy));
             Toast.makeText(this, String.valueOf(tempqty),Toast.LENGTH_SHORT).show();
             fixprice = Integer.valueOf(String.valueOf(pricee));
        } catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        if(fixqty != 0) {
            itemOrdered iorders = new itemOrdered();

//        detaildrinkcombo ddc = new detaildrinkcombo();
//        temporder toFix = new temporder();
//        String tes = to.getName()+", "+to.getPrice()+", "+to.getQty()+ " Added to order"
//            Toast.makeText(this, namaaa, Toast.LENGTH_SHORT).show();
            for (int o = 0;o<listordereditem.size();o++){
                if(listordereditem.get(o).getOrdered_name().equals(namaaa)) {
                    tempqty = listordereditem.get(o).getOrdered_qty();

//                    tempqty += tempqty;
//                    listordereditem.set(o,tempqty);
                    listordereditem.remove(o);
//                    iorders.setOrdered_name(namaaa);
//                    iorders.setOrdered_price(fixprice);

                }
            }

            iorders.setOrdered_name(namaaa);
            iorders.setOrdered_price(fixprice);
            iorders.setOrdered_qty(fixqty+tempqty);


            totalharga += iorders.getOrder_total();

//            String itemtotal = String.valueOf(iorders.getOrder_total());
//            Toast.makeText(this, String.valueOf(totalharga),Toast.LENGTH_SHORT).show();

            TextView tvTotalharga = (TextView) findViewById(R.id.totalharga);
            tvTotalharga.setText(String.valueOf(totalharga));

            listordereditem.add(iorders);
        }

//        listordereditemfix = new ArrayList<>(listordereditem);
//        itemOrdered temptofix = new itemOrdered();

        adapter = new MyorderAdapter(this, listordereditem);
        ordereditem.setAdapter(adapter);

    }


    public void backmenu(View view) {
        Intent backmenu = new Intent(this, MainActivity.class);
        startActivity(backmenu);
    }

    public void paynoww(View view) {
        Intent paynoww = new Intent(this, PayActivity.class);
        paynoww.putExtra("listdatapay", listordereditem);
        totalharga = 0;
        startActivity(paynoww);
        for (int k = 0; k < listordereditem.size(); k++) {
            listordereditem.remove(k);
        }

//        listordereditem.remove(listordereditem);
    }
    Integer fordelete;
    TextView tvdel;
    String delt;
    String pin;
    public void deletee(View view) {
        tvdel = (TextView) findViewById(R.id.item_nameOrder);
        delt = tvdel.getText().toString();
        for (int z = 0; z < listordereditem.size(); z++) {
            if (listordereditem.get(z).getOrdered_name() == delt) {
                pin = listordereditem.get(z).getOrdered_name() + " has been deleted";
                fordelete = listordereditem.get(z).getOrdered_price();
                if (totalharga < 0 ) {
                    totalharga = 0;
                } else {
                    totalharga -= fordelete;
                    listordereditem.remove(z);

                }

            }
        }
        Intent gobackpls = new Intent(this, MainActivity.class);
        startActivity(gobackpls);
    }
}