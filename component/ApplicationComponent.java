package com.example.peopeletech.component;

import android.content.Context;


import com.example.peopeletech.MyApplication;
import com.example.peopeletech.module.ContextModule;
import com.example.peopeletech.module.RetrofitModule;
import com.example.peopeletech.qualifier.ApplicationContext;
import com.example.peopeletech.retrofit.APIInterface;
import com.example.peopeletech.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class })
public interface ApplicationComponent {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);


}
