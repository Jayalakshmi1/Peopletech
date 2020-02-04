package com.example.peopeletech.module;



import com.example.peopeletech.adapter.RecyclerViewAdapter;
import com.example.peopeletech.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleLIst() {
        return new RecyclerViewAdapter(  );
    }

}
