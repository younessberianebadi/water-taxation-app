package io.aets.WaterTaxationBackend.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Subscriber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String subscriberCode;
    private int counterNumber;
    private String first_name;
    private String last_name;
    private boolean isMember;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date last_checked;
    private float last_value;

    public Subscriber(){}

    public Subscriber(String subscriberCode, int counterNumber, String first_name, String last_name, boolean isMember, Date last_checked, float last_value) {
        this.subscriberCode = subscriberCode;
        this.counterNumber = counterNumber;
        this.first_name = first_name;
        this.last_name = last_name;
        this.isMember = isMember;
        this.last_checked = last_checked;
        this.last_value = last_value;
    }

    public int getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(int counterNumber) {
        this.counterNumber = counterNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriberCode() {
        return subscriberCode;
    }

    public void setSubscriberCode(String subscriberCode) {
        this.subscriberCode = subscriberCode;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public Date getLast_checked() {
        return last_checked;
    }

    public void setLast_checked(Date last_checked) {
        this.last_checked = last_checked;
    }

    public float getLast_value() {
        return last_value;
    }

    public void setLast_value(float last_value) {
        this.last_value = last_value;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", subscriberCode='" + subscriberCode + '\'' +
                ", counterNumber=" + counterNumber +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", isMember=" + isMember +
                ", last_checked=" + last_checked +
                ", last_value=" + last_value +
                '}';
    }
}
