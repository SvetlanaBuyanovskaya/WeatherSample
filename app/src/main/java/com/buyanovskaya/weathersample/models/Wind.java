package com.buyanovskaya.weathersample.models;


public class Wind {
    private double speed;

    public String getSpeed() {
        String speed = String.valueOf(this.speed) + " m/sec";
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private double deg;

    public double getDeg() {
        return this.deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}