package com.example.gui;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    float font=20;
    int i=0;
    TextView t1;
    Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.txt);
        b1 =findViewById(R.id.btn1);
        b2 =findViewById(R.id.btn2);
        b3 =findViewById(R.id.btn3);

    }

    public void buttonclick(View view) {
        if (view.getId() == R.id.btn1) {
            if(i==0) {
                t1.setTextColor(Color.RED);
                i=1;
            }
            else{
                t1.setTextColor(Color.GREEN);
                i=0;
            }
        }
        else if(view.getId() == R.id.btn2){
            t1.setTextSize(font);
            font+=5;
        }
        else{
            t1.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
        }
    }
}
