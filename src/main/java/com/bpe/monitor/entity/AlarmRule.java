package com.bpe.monitor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by polinchw on 6/4/17.
 */
@Entity
public class AlarmRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "account_fk")
    private Account account;

    @OneToMany
    @JoinColumn(name="rule_fk")
    List<AlarmReading> alarmReadings;

    private AlarmEnum alarmType;

    private float low;

    private float high;

    private String emailToAlert;

    public long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AlarmEnum getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(AlarmEnum alarmType) {
        this.alarmType = alarmType;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public String getEmailToAlert() {
        return emailToAlert;
    }

    public void setEmailToAlert(String emailToAlert) {
        this.emailToAlert = emailToAlert;
    }

    public List<AlarmReading> getAlarmReadings() {
        return alarmReadings;
    }

    public void setAlarmReadings(List<AlarmReading> alarmReadings) {
        this.alarmReadings = alarmReadings;
    }
}
