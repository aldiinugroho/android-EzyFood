package com.example.uts;

import android.content.Intent;

import java.io.Serializable;

public class itemOrdered implements Serializable {
    String ordered_name;
    Integer ordered_price;
    Integer ordered_qty;
    Integer order_total = 0;


    public Integer getOrder_total() {
        return ordered_qty * ordered_price;
    }

    public void setOrder_total(Integer order_total) {
        this.order_total = order_total;
    }

    public String getOrdered_name() {
        return ordered_name;
    }

    public void setOrdered_name(String ordered_name) {
        this.ordered_name = ordered_name;
    }

    public Integer getOrdered_price() {
        return ordered_price;
    }

    public void setOrdered_price(Integer ordered_price) {
        this.ordered_price = ordered_price;
    }

    public Integer getOrdered_qty() {
        return ordered_qty;
    }

    public void setOrdered_qty(Integer ordered_qty) {
        this.ordered_qty = ordered_qty;
    }


}
