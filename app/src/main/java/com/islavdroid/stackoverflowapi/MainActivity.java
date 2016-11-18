package com.islavdroid.stackoverflowapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islavdroid.stackoverflowapi.UserAdapter.RecUsersAdapter;
import com.islavdroid.stackoverflowapi.model.User;
import com.islavdroid.stackoverflowapi.model.UsersReceived;
import com.islavdroid.stackoverflowapi.rest.ApiClient;
import com.islavdroid.stackoverflowapi.rest.UserEndPoints;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    List<User>mDataSource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.usersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter =new RecUsersAdapter(mDataSource);
        recyclerView.setAdapter(myAdapter);
        loadUsers();
    }

    private void loadUsers() {
        UserEndPoints apiService = ApiClient.getClient().create(UserEndPoints.class);
        Call<UsersReceived>call =apiService.getUsers("reputation");
     call.enqueue(new Callback<UsersReceived>() {
         @Override
         public void onResponse(Call<UsersReceived> call, Response<UsersReceived> response) {
             List<User>users = response.body().getUsers();
             mDataSource.clear();
             mDataSource.addAll(response.body().getUsers());
             myAdapter.notifyDataSetChanged();
         }

         @Override
         public void onFailure(Call<UsersReceived> call, Throwable t) {

         }
     });
    }
}
