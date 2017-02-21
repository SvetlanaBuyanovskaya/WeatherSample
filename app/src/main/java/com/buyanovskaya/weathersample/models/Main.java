package com.buyanovskaya.weathersample.models;


public class Main {
    private double temp;

    public String getTemp() {
        String temp = String.valueOf((int) this.temp) + "°C";
        return
                temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    private double pressure;

    public double getPressure() {
        return this.pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    private int humidity;

    public String getHumidity() {
        String humidity = String.valueOf(this.humidity) + " %";
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    private double temp_min;

    public double getTempMin() {
        return this.temp_min;
    }

    public void setTempMin(double temp_min) {
        this.temp_min = temp_min;
    }

    private double temp_max;

    public double getTempMax() {
        return this.temp_max;
    }

    public void setTempMax(double temp_max) {
        this.temp_max = temp_max;
    }
}