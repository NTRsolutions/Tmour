package com.sismatix.tmour.Model;

public class OrderSummary_Model {
    String order_qty,order_title,order_tot;

    public OrderSummary_Model(String order_qty, String order_title, String order_tot) {
        this.order_qty = order_qty;
        this.order_title = order_title;
        this.order_tot = order_tot;
    }

    public String getOrder_qty() {
        return order_qty;
    }

    public void setOrder_qty(String order_qty) {
        this.order_qty = order_qty;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public String getOrder_tot() {
        return order_tot;
    }

    public void setOrder_tot(String order_tot) {
        this.order_tot = order_tot;
    }
}
