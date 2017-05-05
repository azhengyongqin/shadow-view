package com.example.shadowviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.shadowviewlibrary.CustomShadowView;

public class MainActivity extends AppCompatActivity {

    private CustomShadowView shadowView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shadowView = (CustomShadowView) findViewById(R.id.shadow_view);
        textView = (TextView) findViewById(R.id.tv_test);
        textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}
