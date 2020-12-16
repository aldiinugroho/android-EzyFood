package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOError;
import java.util.ArrayList;
import java.util.Vector;

public class detaildrinkcombo extends AppCompatActivity {
    ImageView ivGambar;
    TextView tvnama;
    TextView tvprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildrinkcombo);

        ivGambar = (ImageView) findViewById(R.id.imageitem);
        tvnama = (TextView) findViewById(R.id.combo_itemnama);
        tvprice = (TextView) findViewById(R.id.combo_itemprice);

        String pricefix = String.valueOf(getIntent().getIntExtra("drinkprice",0));

        tvnama.setText(getIntent().getStringExtra("drinkname"));
        tvprice.setText(pricefix);
        ivGambar.setImageResource(getIntent().getIntExtra("drinkimage",0));
    }

    Integer quant = 0;
    public void minus(View view) {
        TextView quantity;
        quantity = (TextView) findViewById(R.id.qty);
        if (quant <= 0) {
            quant = 0;
        } else {
            quant--;
        }
        quantity.setText(""+quant);
    }

    public void plus(View view) {
        TextView quantity;
        quantity = (TextView) findViewById(R.id.qty);
        quant++;
        quantity.setText(""+quant);
    }

    TextView ordered_name;
    TextView ordered_price;
    TextView ordered_qty;

//    temporder totes = new temporder();

//    public ArrayList<temporder> listtemporder () {
//        ArrayList<temporder> testing = new ArrayList<>();
//        for (int i = 0;i < testing.size(); i++) {
//            testing.get(i).getPrice();
//            testing.get(i).getQty();
//            testing.get(i).getName();
//        }
////        totesting.getName();
////        totesting.getQty();
////        totesting.getPrice();
//
//        return testing;
//    }

    public void ordernow(View view) {
        ordered_name = (TextView) findViewById(R.id.combo_itemnama);
        ordered_price = (TextView) findViewById(R.id.combo_itemprice);
        ordered_qty = (TextView) findViewById(R.id.qty);

        String namez = ordered_name.getText().toString();
        String pricez = ordered_price.getText().toString();
        String qtyz = ordered_qty.getText().toString();
//        Integer fixqty = 0;
//        Integer fixprice = 0;
//        try {
//            fixqty = Integer.valueOf(String.valueOf(pricez));
//            fixprice = Integer.valueOf(String.valueOf(qtyz));
//        } catch(NumberFormatException nfe) {
//            nfe.printStackTrace();
//        }

        Intent toMyorder = new Intent(this, OrderedActivity.class);
        toMyorder.putExtra("namee", namez);
        toMyorder.putExtra("pricee", pricez);
        toMyorder.putExtra("qtyy", qtyz);
        startActivity(toMyorder);
    }


    public void backtomenuitem(View view) {
        Intent backtomenuitem = new Intent(this, MainActivity.class);
        startActivity(backtomenuitem);
    }
}