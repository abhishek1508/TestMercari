package com.android.mercariinterviewapp;

import android.app.Application;

import com.android.mercariinterviewapp.dependencyinjection.components.AppComponent;
import com.android.mercariinterviewapp.dependencyinjection.components.DaggerAppComponent;
import com.android.mercariinterviewapp.dependencyinjection.modules.AppModule;
import com.android.mercariinterviewapp.dependencyinjection.modules.NetworkModule;

import timber.log.Timber;

/**
 * Created by AbhishekKejriwal on 7/12/2017.
 */

public class MercariApp extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                //.networkModule(new NetworkModule("baseUrl"))
                .build();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
