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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewholderFood> {
    Context ctx;
    ArrayList<Drink> listsfood;

    public FoodAdapter(Context ctx, ArrayList<Drink> listsfood) {
        this.ctx = ctx;
        this.listsfood = listsfood;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewholderFood onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.snacklayout_row, parent, false);
        return new ViewholderFood(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewholderFood holder, int position) {
        final Drink food = listsfood.get(position);
        holder.foodImage.setImageResource(food.drinkImage);
        holder.foodName.setText(food.drink_name);
        holder.foodPrice.setText(String.valueOf(food.price));

        holder.presscombofood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tocombodetail = new Intent(ctx, detaildrinkcombo.class);

                tocombodetail.putExtra("drinkname",food.drink_name);
                tocombodetail.putExtra("drinkprice",food.price);
                tocombodetail.putExtra("drinkimage",food.drinkImage);

                ctx.startActivity(tocombodetail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listsfood.size();
    }

    class ViewholderFood extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodPrice;
        TextView foodName;
        LinearLayout presscombofood;

        public ViewholderFood(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.snackImage);
            foodName = itemView.findViewById(R.id.snackName);
            foodPrice = itemView.findViewById(R.id.snackPrice);
            presscombofood = itemView.findViewById(R.id.presscombosnack);

        }

    }
}
