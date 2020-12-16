package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.Viewholder> {
    Context ctx;
    ArrayList<Drink> listdrink;

    public DrinkAdapter(Context ctx, ArrayList<Drink> listdrink) {
        this.ctx = ctx;
        this.listdrink = listdrink;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.drinklayout_row, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final Drink drink = listdrink.get(position);
        holder.drinkImage.setImageResource(drink.drinkImage);
        holder.drinkName.setText(drink.drink_name);
        holder.drinkPrice.setText(String.valueOf(drink.price));

        holder.presscombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tocombodetail = new Intent(ctx, detaildrinkcombo.class);

                tocombodetail.putExtra("drinkname",drink.drink_name);
                tocombodetail.putExtra("drinkprice",drink.price);
                tocombodetail.putExtra("drinkimage",drink.drinkImage);

                ctx.startActivity(tocombodetail);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listdrink.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        ImageView drinkImage;
        TextView drinkPrice;
        TextView drinkName;
        LinearLayout presscombo;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            drinkImage = itemView.findViewById(R.id.drinkImage);
            drinkName = itemView.findViewById(R.id.drinkName);
            drinkPrice = itemView.findViewById(R.id.drinkPrice);
            presscombo = itemView.findViewById(R.id.presscombo);

        }

    }
}