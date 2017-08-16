package com.example.admin.fivesystembroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DynamicReceiver dynamicReceiver;
    IntentFilter intentFilter;
    RecyclerView rvRandomsList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRandomsList = (RecyclerView) findViewById(R.id.rvRandomsList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvRandomsList.setLayoutManager(layoutManager);
        rvRandomsList.setItemAnimator(itemAnimator);

        dynamicReceiver = new DynamicReceiver(rvRandomsList);

        for(int i = 0; i<(new Random()).nextInt(100); i++) {
            Intent intIntent = new Intent(this, IntentService.class);
            intIntent.setAction("createObject");
            startService(intIntent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        intentFilter = new IntentFilter("doSomethingElse");
        intentFilter.addAction("doSomething");
        intentFilter.addAction("TypeMessage");
        intentFilter.addAction("list");
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        intentFilter.addAction(Intent.ACTION_WALLPAPER_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(dynamicReceiver,intentFilter);

    }
    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(dynamicReceiver);
    }
}
