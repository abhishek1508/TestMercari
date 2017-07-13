package com.android.mercariinterviewapp.dependencyinjection.components;


import com.android.mercariinterviewapp.dependencyinjection.modules.HomeModule;
import com.android.mercariinterviewapp.dependencyinjection.scopes.HomeScope;
import com.android.mercariinterviewapp.home.HomeActivity;

import dagger.Component;

@HomeScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeActivity target);
}
