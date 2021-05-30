package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    com.example.canvas.MyConvas myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCanvas=new com.example.canvas.MyConvas(this,null);
        setContentView(myCanvas);
    }
}