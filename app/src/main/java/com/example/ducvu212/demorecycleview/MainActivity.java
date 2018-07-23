package com.example.ducvu212.demorecycleview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        FragmentManager mManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mManager.beginTransaction() ;
        mTransaction.replace(R.id.layout_main, MainFragment.newInstance(), "") ;
        mTransaction.commit() ;
    }
}
