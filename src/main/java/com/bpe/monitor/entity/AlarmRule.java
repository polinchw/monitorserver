package com.bpe.monitor.entity;

import javax.persistence.*;
import java.util.*;

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

    @Column
    private AlarmEnum alarmType;

    @Column
    private float low;

    @Column
    private float high;

    @Column
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
        if(alarmReadings == null) {
            alarmReadings = new ArrayList<AlarmReading>();
        }
        return alarmReadings;
    }

    public void setAlarmReadings(List<AlarmReading> alarmReadings) {
        this.alarmReadings = alarmReadings;
    }
}
