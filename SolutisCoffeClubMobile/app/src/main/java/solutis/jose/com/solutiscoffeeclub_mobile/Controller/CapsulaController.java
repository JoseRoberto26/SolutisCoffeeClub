package solutis.jose.com.solutiscoffeeclub_mobile.Controller;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import solutis.jose.com.solutiscoffeeclub_mobile.Capsula;

public interface CapsulaController {

    @GET("capsulas/pegar")
    Call<ArrayList<Capsula>> getCapsulas();

    @DELETE("capsulas/{id}")
    Call<Boolean> deleteCapsula(@Path("id") long id);

    @POST("capsulas")
    Call<Capsula> postCapsula(@Body Capsula capsula);
}
