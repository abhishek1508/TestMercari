package com.android.mercariinterviewapp.dependencyinjection.components;

import com.android.mercariinterviewapp.MercariApp;
import com.android.mercariinterviewapp.dependencyinjection.modules.AppModule;
import com.android.mercariinterviewapp.dependencyinjection.modules.NetworkModule;
import com.android.mercariinterviewapp.dependencyinjection.scopes.AppScope;

import dagger.Component;
import retrofit2.Retrofit;

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MercariApp app);

    Retrofit retrofit();
}
