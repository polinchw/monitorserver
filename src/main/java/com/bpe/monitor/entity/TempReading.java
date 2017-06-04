package com.bpe.monitor.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by polinchw on 6/4/17.
 */
@Entity
@Table(name = "tempReading")
public class TempReading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "device_fk")
    @NotNull
    private Device device;

    private float reading;

    @Enumerated(EnumType.STRING)
    private TempEnum tempType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecorded;

    public TempReading(Device device) {
        this.device = device;
    }

    public long getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public float getReading() {
        return reading;
    }

    public void setReading(float reading) {
        this.reading = reading;
    }

    public TempEnum getTempType() {
        return tempType;
    }

    public void setTempType(TempEnum tempType) {
        this.tempType = tempType;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
}
