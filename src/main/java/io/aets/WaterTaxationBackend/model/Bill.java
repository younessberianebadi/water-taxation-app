package io.aets.WaterTaxationBackend.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date old_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long subscriberId;
    @Column(nullable = false, updatable = false)
    private String bill_serial_number;
    private float old_value;
    private float new_value;
    private float difference;
    private float first_tier;
    private float second_tier;
    private float third_tier;
    private float total;
    private boolean paid;

    public Bill(){}


    public float getDifference() {
        return difference;
    }

    public void setDifference(float difference) {
        this.difference = difference;
    }

    public Bill(Date old_date, Date date, Long subscriberId, String bill_serial_number, float old_value, float new_value, float difference, float first_tier, float second_tier, float third_tier, float total, boolean paid) {
        this.old_date = old_date;
        this.date = date;
        this.subscriberId = subscriberId;
        this.bill_serial_number = bill_serial_number;
        this.old_value = old_value;
        this.new_value = new_value;
        this.difference = difference;
        this.first_tier = first_tier;
        this.second_tier = second_tier;
        this.third_tier = third_tier;
        this.total = total;
        this.paid = paid;
    }

    public Date getOld_date() {
        return old_date;
    }

    public void setOld_date(Date old_date) {
        this.old_date = old_date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getBill_serial_number() {
        return bill_serial_number;
    }

    public void setBill_serial_number(String bill_serial_number) {
        this.bill_serial_number = bill_serial_number;
    }

    public float getOld_value() {
        return old_value;
    }

    public void setOld_value(float old_value) {
        this.old_value = old_value;
    }

    public float getNew_value() {
        return new_value;
    }

    public void setNew_value(float new_value) {
        this.new_value = new_value;
    }

    public float getFirst_tier() {
        return first_tier;
    }

    public void setFirst_tier(float first_tier) {
        this.first_tier = first_tier;
    }

    public float getSecond_tier() {
        return second_tier;
    }

    public void setSecond_tier(float second_tier) {
        this.second_tier = second_tier;
    }

    public float getThird_tier() {
        return third_tier;
    }

    public void setThird_tier(float third_tier) {
        this.third_tier = third_tier;
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", old_date=" + old_date +
                ", date=" + date +
                ", subscriberId=" + subscriberId +
                ", bill_serial_number='" + bill_serial_number + '\'' +
                ", old_value=" + old_value +
                ", new_value=" + new_value +
                ", difference=" + difference +
                ", first_tier=" + first_tier +
                ", second_tier=" + second_tier +
                ", third_tier=" + third_tier +
                ", total=" + total +
                ", paid=" + paid +
                '}';
    }
}
