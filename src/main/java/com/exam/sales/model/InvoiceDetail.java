package com.exam.sales.model;

import java.io.Serializable;

public class InvoiceDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long invoiceId;
    private Long productId;
    private double price;
    private int total;

    public InvoiceDetail() {}

    public InvoiceDetail(Long invoiceId, Long productId, double price, int total) {
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.price = price;
        this.total = total;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
