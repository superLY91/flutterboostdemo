package com.example.flutterboostdemo;

import android.app.Application;

import com.example.flutterboostdemo.flutter.FlutterMediator;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FlutterMediator.init(this);
    }
}
