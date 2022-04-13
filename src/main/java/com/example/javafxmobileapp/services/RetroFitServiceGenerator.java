package com.example.javafxmobileapp.services;



import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Base64;


public class RetroFitServiceGenerator {

    public static String userName;
    public static String password;
    public static String userEmail;

    private static final String BASE_URL = "http://localhost:8080";


    private static Retrofit.Builder builder
            = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient
            = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String username,String password) {
        if (username != null && username != null) {
            String base64Credential = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
            httpClient.interceptors().clear();
            httpClient.addInterceptor( chain -> {
                Request original = chain.request();
                Request.Builder builder1 = original.newBuilder()
                        .header("Authorization", "Basic " + base64Credential);
                Request request = builder1.build();
                return chain.proceed(request);
            });
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }



    public static <S> S createAuthService(Class<S> gameServiceClass) {

        return createService(gameServiceClass,userName,password);
    }
}













































