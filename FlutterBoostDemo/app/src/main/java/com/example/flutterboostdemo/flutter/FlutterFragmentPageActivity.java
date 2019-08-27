package com.example.flutterboostdemo.flutter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.flutterboostdemo.R;

public class FlutterFragmentPageActivity extends AppCompatActivity {

    private FlutterFragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.flutter_fragment_page);

        mFragment = FlutterFragment.instance("hello");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_stub, mFragment)
                .commit();
    }
}
