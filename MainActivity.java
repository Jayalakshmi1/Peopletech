package com.example.peopeletech;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.example.peopeletech.model.Info;
import com.example.peopeletech.adapter.RecyclerViewAdapter;
import com.example.peopeletech.component.ApplicationComponent;
import com.example.peopeletech.component.DaggerMainActivityComponent;
import com.example.peopeletech.component.MainActivityComponent;
import com.example.peopeletech.module.MainActivityContextModule;
import com.example.peopeletech.qualifier.ActivityContext;
import com.example.peopeletech.qualifier.ApplicationContext;
import com.example.peopeletech.retrofit.APIInterface;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;



    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager llManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(llManager);

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter( recyclerViewAdapter);

        apiInterface.getPeople("json").enqueue(new Callback<Info>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                populateRecyclerView(response.body().rows);
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });
    }


    private void populateRecyclerView(List<Info.Row> response) {
        List<Info.Row> filter = new ArrayList<>(  );
        for (Info.Row row : response){
            if(row.getTitle()!=null ){
                filter.add( row );
            }
        }
        recyclerViewAdapter.setData(filter);
    }


}
