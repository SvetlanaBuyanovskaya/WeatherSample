package com.buyanovskaya.weathersample.ui;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.buyanovskaya.weathersample.R;
import com.buyanovskaya.weathersample.utils.Constants;
import com.buyanovskaya.weathersample.models.DetailedWeather;
import com.buyanovskaya.weathersample.models.Weather;
import com.buyanovskaya.weathersample.retrofitApi.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView tvTemp;
    TextView tvSpeed;
    TextView tvDescription;
    TextView tvName;
    TextView tvDate;
    TextView tvHumidity;
    Spinner spinner;
    ImageView image;
    long cityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvTemp = (TextView) findViewById(R.id.tvTemp);
        tvSpeed = (TextView) findViewById(R.id.tvSpeed);
        tvName = (TextView) findViewById(R.id.tvName);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        image = (ImageView) findViewById(R.id.image);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int chosenCityIndex = spinner.getSelectedItemPosition();
                switch (chosenCityIndex) {
                    case 0:
                        cityId = Constants.CITY_KIEV_ID;
                        break;
                    case 1:
                        cityId = Constants.CITY_ODESSA_ID;
                        break;
                    case 2:
                        cityId = Constants.CITY_LVIV_ID;
                        break;
                    case 3:
                        cityId = Constants.CITY_KHARKIV_ID;
                        break;
                }
                RetrofitClient.getInfoByCity(cityId, weatherCallback);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setupUI(DetailedWeather detailedWeather) {
        ArrayList<Weather> weatherArrayList = detailedWeather.getWeather();
        tvDescription.setText(weatherArrayList.get(0).getDescription());
        tvHumidity.setText(detailedWeather.getMain().getHumidity());
        tvSpeed.setText(detailedWeather.getWind().getSpeed());
        tvTemp.setText(detailedWeather.getMain().getTemp());
        tvName.setText(detailedWeather.getName());
        String formattedDate = convertDate(detailedWeather.getDt());
        tvDate.setText(formattedDate);
        tvDate.setText(formattedDate);
        Picasso.with(getApplicationContext()).load(Constants.IMG_URL + weatherArrayList.get(0).getIcon() + ".png")
                .fit()
                .into(image);
    }

    private String convertDate(long unixSeconds) {
        Date date = new Date(unixSeconds * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }

    private Callback<DetailedWeather> weatherCallback = new Callback<DetailedWeather>() {
        @Override
        public void onResponse(Response<DetailedWeather> response, Retrofit retrofit) {
            setupUI(response.body());
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

}
