package com.sismatix.tmour.Model;

public class MyOrder_Model {
    String order_image,customer_name,order_date,order_time,order_id,order_status;

    public MyOrder_Model(String order_image, String customer_name, String order_date, String order_time, String order_id, String order_status) {
        this.order_image = order_image;
        this.customer_name = customer_name;
        this.order_date = order_date;
        this.order_time = order_time;
        this.order_id = order_id;
        this.order_status = order_status;
    }

    public String getOrder_image() {
        return order_image;
    }

    public void setOrder_image(String order_image) {
        this.order_image = order_image;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
