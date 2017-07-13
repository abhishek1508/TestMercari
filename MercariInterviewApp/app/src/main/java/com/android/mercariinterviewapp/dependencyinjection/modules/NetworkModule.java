package com.android.mercariinterviewapp.dependencyinjection.modules;

import com.android.mercariinterviewapp.dependencyinjection.scopes.AppScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @AppScope
    @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @AppScope
    @Provides
    OkHttpClient provideOkhttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.build();
    }

    @AppScope
    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }
}
