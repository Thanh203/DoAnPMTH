package com.example.doanpmth.Classes;

public class OrderDetail {
    private int orderdetailid;
    private int orderId;
    private int bookId;
    private int quantity;
    public OrderDetail(int orderdetailid, int orderId, int bookId, int quantity) {
        this.orderdetailid = orderdetailid;
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public int getOrderdetailid() {
        return orderdetailid;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderdetailid(int orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
