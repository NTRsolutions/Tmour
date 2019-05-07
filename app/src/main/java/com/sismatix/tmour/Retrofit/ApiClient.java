package com.sismatix.tmour.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://elmizan.demoproject.info/api/";
    public static final String BASE_URLL = "http://pratikbutani.x10.mx/";
    public static final String user_type = "lawyer";
    public static final String user_status = "1";
    private static Retrofit retrofit = null;
    public  static String  PAGE="1",PER_PAGE="10";

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URLL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
