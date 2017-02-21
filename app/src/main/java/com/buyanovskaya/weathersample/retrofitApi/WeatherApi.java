package com.buyanovskaya.weathersample.retrofitApi;

import com.buyanovskaya.weathersample.models.DetailedWeather;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Svetlana on 26.01.2017.
 */
public interface WeatherApi {

    @GET("weather")
    Call<DetailedWeather> loadInfoByCity(@Query("id") long id,@Query("units")String units, @Query("appid") String api_key);

//    @GET("data/2.5/forecast/daily?id=703448&units=metric&appid=517de79878ecaf7ec00481cfc5cca87e")
//    Call<DetailedWeather> loadInfoByCity();
//    @GET("/data/2.5/forecast/daily?id=698740&units=metric&appid=517de79878ecaf7ec00481cfc5cca87e")
//    Call<Root> loadInfoByOdessa();
//    @GET("/data/2.5/forecast/daily?id=709717&units=metric&appid=517de79878ecaf7ec00481cfc5cca87e")
//    Call<Root> loadInfoByDonetsk();
//    @GET("/data/2.5/forecast/daily?id=709930&units=metric&appid=517de79878ecaf7ec00481cfc5cca87e")
//    Call<Root> loadInfoByDnipro();

}
