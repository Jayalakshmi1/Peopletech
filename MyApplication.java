package com.example.peopeletech;

import android.app.Activity;
import android.app.Application;

import com.example.peopeletech.component.ApplicationComponent;
import com.example.peopeletech.component.DaggerApplicationComponent;
import com.example.peopeletech.module.ContextModule;

/**
 * Created by jbathula on 31,January,2020
 */
public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule( new ContextModule( this ) ).build();
        applicationComponent.injectApplication( this );

    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}