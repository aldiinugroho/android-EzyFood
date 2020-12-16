package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyorderAdapter extends RecyclerView.Adapter<MyorderAdapter.ViewHolderMyorder> {

    Context ctx;
    ArrayList<itemOrdered> listitemyorder;

    public MyorderAdapter(Context ctx, ArrayList<itemOrdered> listitemyorder) {
        this.ctx = ctx;
        this.listitemyorder = listitemyorder;
    }

    @NonNull
    @Override
    public ViewHolderMyorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.myorder_row, parent, false);
        return new ViewHolderMyorder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMyorder holder, int position) {
        itemOrdered imyordered = listitemyorder.get(position);

        holder.tvMyorderprice_item.setText(String.valueOf(imyordered.ordered_price));
        holder.tvMyorderqty_item.setText(String.valueOf(imyordered.ordered_qty));
        holder.tvMyorderName_item.setText(imyordered.ordered_name);
    }

    @Override
    public int getItemCount() {
        return listitemyorder.size();
    }

    class ViewHolderMyorder extends RecyclerView.ViewHolder {

        TextView tvMyorderName_item;
        TextView tvMyorderprice_item;
        TextView tvMyorderqty_item;

        public ViewHolderMyorder(@NonNull View itemView) {
            super(itemView);

            tvMyorderName_item = itemView.findViewById(R.id.item_nameOrder);
            tvMyorderprice_item = itemView.findViewById(R.id.item_hargaOrder);
            tvMyorderqty_item = itemView.findViewById(R.id.item_qtyOrder);
        }
    }
}
