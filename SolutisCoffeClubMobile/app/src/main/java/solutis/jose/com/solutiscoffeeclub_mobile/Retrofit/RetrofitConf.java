package solutis.jose.com.solutiscoffeeclub_mobile.Retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import solutis.jose.com.solutiscoffeeclub_mobile.Controller.CapsulaController;

public class RetrofitConf {

    private final Retrofit retrofit;

    public RetrofitConf() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(10, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS).build();

        this.retrofit = new Retrofit.Builder()
        .baseUrl("http://172.29.50.50:8080/")
        .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build())
        .build();
    }

    public CapsulaController getCapsulaController(){
        return this.retrofit.create(CapsulaController.class);
    }
}
