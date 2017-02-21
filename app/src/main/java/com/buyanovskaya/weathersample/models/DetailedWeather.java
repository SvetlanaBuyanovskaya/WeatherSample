package com.buyanovskaya.weathersample.models;

import java.util.ArrayList;

public class DetailedWeather {
    private ArrayList<Weather> weather;

    public ArrayList<Weather> getWeather() {
        return this.weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    private String base;

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    private Main main;

    public Main getMain() {
        return this.main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private int visibility;

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    private Wind wind;

    public Wind getWind() {
        return this.wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    private long dt;

    public long getDt() {
        return this.dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }


    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int cod;

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}

