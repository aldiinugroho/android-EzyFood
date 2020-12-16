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

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.ViewholderSnack> {
    Context ctx;
    ArrayList<Drink> listsnack;

    public SnackAdapter(Context ctx, ArrayList<Drink> listsnack) {
        this.ctx = ctx;
        this.listsnack = listsnack;
    }

    @NonNull
    @Override
    public ViewholderSnack onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.snacklayout_row, parent, false);
        return new ViewholderSnack(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewholderSnack holder, int position) {
        final Drink snack = listsnack.get(position);
        holder.snackImage.setImageResource(snack.drinkImage);
        holder.snackName.setText(snack.drink_name);
        holder.snackPrice.setText(String.valueOf(snack.price));

        holder.presscombosnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tocombodetail = new Intent(ctx, detaildrinkcombo.class);

                tocombodetail.putExtra("drinkname",snack.drink_name);
                tocombodetail.putExtra("drinkprice",snack.price);
                tocombodetail.putExtra("drinkimage",snack.drinkImage);

                ctx.startActivity(tocombodetail);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listsnack.size();
    }

    class ViewholderSnack extends RecyclerView.ViewHolder {

        ImageView snackImage;
        TextView snackPrice;
        TextView snackName;
        LinearLayout presscombosnack;

        public ViewholderSnack(@NonNull View itemView) {
            super(itemView);

            snackImage = itemView.findViewById(R.id.snackImage);
            snackName = itemView.findViewById(R.id.snackName);
            snackPrice = itemView.findViewById(R.id.snackPrice);
            presscombosnack = itemView.findViewById(R.id.presscombosnack);

        }

    }
}