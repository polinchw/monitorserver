package com.bpe.monitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by polinchw on 5/31/17.
 */
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "account_fk")
    @NotNull
    private Account account;

    @Column(length = 15)
    @NotNull
    private String name;

    @Column(length = 40)
    @NotNull
    private String description;

    private float lat;

    private float longitue;

    private long heightAboveSeaLevel;

    public void setId(long id) {this.id = id;}

    public long getId() {
        return id;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLongitue(float longitue) {
        this.longitue = longitue;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLat() {
        return lat;
    }

    public float getLongitue() {
        return longitue;
    }

    public long getHeightAboveSeaLevel() {
        return heightAboveSeaLevel;
    }

    public void setHeightAboveSeaLevel(long heightAboveSeaLevel) {
        this.heightAboveSeaLevel = heightAboveSeaLevel;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lat=" + lat +
                ", longitue=" + longitue +
                ", heightAboveSeaLevel=" + heightAboveSeaLevel +
                '}';
    }
}
