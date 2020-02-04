package com.example.peopeletech.component;

import android.content.Context;


import com.example.peopeletech.MainActivity;
import com.example.peopeletech.module.AdapterModule;
import com.example.peopeletech.qualifier.ActivityContext;
import com.example.peopeletech.scopes.ActivityScope;

import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(MainActivity mainActivity);
}
