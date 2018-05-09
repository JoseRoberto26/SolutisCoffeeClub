package solutis.jose.com.solutiscoffeeclub_mobile.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import solutis.jose.com.solutiscoffeeclub_mobile.Controller.CapsulaController;

public class RetrofitConf {

    private final Retrofit retrofit;

    public RetrofitConf(Retrofit retrofit) {
        this.retrofit = new Retrofit.Builder()
        .baseUrl("http://172.29.20.92:8080/capsulas/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }

    public CapsulaController getCapsulaController(){
        return this.retrofit.create(CapsulaController.class);
    }
}
