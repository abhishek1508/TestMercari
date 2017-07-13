package com.android.mercariinterviewapp.dependencyinjection.modules;

import com.android.mercariinterviewapp.MercariApp;
import com.android.mercariinterviewapp.dependencyinjection.scopes.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MercariApp context;

    public AppModule(MercariApp context) {
        this.context = context;
    }

    @Provides
    @AppScope
    public MercariApp getContext() {
        return context;
    }
}
