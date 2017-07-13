package com.android.mercariinterviewapp.dependencyinjection.modules;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;

@Module
public class HomeModule {

    private AppCompatActivity appCompatActivity;

    public HomeModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }
}
