package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.ViewHolderPay> {

    Context ctx;
    ArrayList<itemOrdered> listitemypay;

    public PayAdapter(Context ctx, ArrayList<itemOrdered> listitemypay) {
        this.ctx = ctx;
        this.listitemypay = listitemypay;
    }

    @NonNull
    @Override
    public ViewHolderPay onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.pay_row, parent, false);
        return new ViewHolderPay(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPay holder, int position) {
        itemOrdered payedd = listitemypay.get(position);

        holder.payprice_item.setText(String.valueOf(payedd.ordered_price));
        holder.payqty_item.setText(String.valueOf(payedd.ordered_qty));
        holder.payName_item.setText(payedd.ordered_name);
    }

    @Override
    public int getItemCount() {
        return listitemypay.size();
    }

    class ViewHolderPay extends RecyclerView.ViewHolder {

        TextView payName_item;
        TextView payprice_item;
        TextView payqty_item;

        public ViewHolderPay(@NonNull View itemView) {
            super(itemView);

            payName_item = itemView.findViewById(R.id.paynameOrder);
            payprice_item = itemView.findViewById(R.id.payhargaOrder);
            payqty_item = itemView.findViewById(R.id.payqtyOrder);
        }
    }
}
