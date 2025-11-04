package com.exam.sales.model;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long invoiceId;
    private Long userId;
    private Date time;
    private String status;

    public Invoice() {}

    public Invoice(Long invoiceId, Long userId, Date time, String status) {
        this.invoiceId = invoiceId;
        this.userId = userId;
        this.time = time;
        this.status = status;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
