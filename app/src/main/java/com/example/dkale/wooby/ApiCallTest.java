package com.example.dkale.wooby;

import com.apollographql.apollo.ApolloClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class ApiCallTest {

    private static final String BASE_URL = "https://graphql.anilist.co";
    private static ApolloClient myApolloClient;
    public static ApolloClient getMyApolloClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        myApolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build();
        return myApolloClient;
    }
}
