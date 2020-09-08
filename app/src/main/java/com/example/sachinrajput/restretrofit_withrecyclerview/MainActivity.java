package com.example.sachinrajput.restretrofit_withrecyclerview;

import android.content.BroadcastReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sachinrajput.restretrofit_withrecyclerview.adapters.RecyclerViewAdapter;
import com.example.sachinrajput.restretrofit_withrecyclerview.interfacebaseURL.RequestInterface;
import com.example.sachinrajput.restretrofit_withrecyclerview.pojo.Data;
import com.example.sachinrajput.restretrofit_withrecyclerview.pojo.DataItems;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DataItems> dataArrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    ProgressBar progress;
    private BroadcastReceiver MyReceiver = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getData(View view) {
        progress=(ProgressBar)findViewById(R.id.progress);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setHasFixedSize(true);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://reqres.in/")
                .build();
             //to add the base URL in to Sub URL
            final RequestInterface requestInterface= retrofit.create(RequestInterface.class);
            Call<Data>call=requestInterface.getData();
          // progress.setVisibility(View.VISIBLE);
           call.enqueue(new Callback<Data>() {
               @Override
               public void onResponse(Call<Data> call, Response<Data> response) {
                   if (response.isSuccessful()){
                      // progress.setVisibility(View.VISIBLE);
                       if (response!=null && response.body().getDataItemses()!=null) {
                           dataArrayList = response.body().getDataItemses();
                           recyclerViewAdapter = new RecyclerViewAdapter(dataArrayList);
                             progress.setVisibility(View.GONE);
                           recyclerView.setAdapter(recyclerViewAdapter);
                       }
                   }
               }
               @Override
               public void onFailure(Call<Data> call, Throwable t) {

               }
           });


    }

    public void hideData(View view) {
        if (dataArrayList!=null){
            recyclerView.setVisibility(View.GONE);
        }

    }
}
