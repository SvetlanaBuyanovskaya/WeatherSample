package com.buyanovskaya.weathersample.retrofitApi;

import com.buyanovskaya.weathersample.models.DetailedWeather;
import com.buyanovskaya.weathersample.utils.Constants;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetrofitClient {
    public static void getInfoByCity(long cityId, Callback<DetailedWeather> weatherCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApi service = retrofit.create(WeatherApi.class);
        Call<DetailedWeather> call = service.loadInfoByCity(cityId, Constants.units, Constants.APP_ID);
        call.enqueue(weatherCallback);
    }

}
