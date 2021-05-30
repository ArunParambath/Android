package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button button;
    RadioButton radioButton;
    CheckBox c,c2,c3,c4;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.grp);
        button=findViewById(R.id.b);
        c=findViewById(R.id.checkBox);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);
        c4=findViewById(R.id.checkBox4);
        toggleButton=findViewById(R.id.tog);
        c.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c.isChecked()){
                    Toast.makeText(MainActivity.this, "Pizza is selected. Rs 100", Toast.LENGTH_SHORT).show();
                }
            }
        });

        c2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c2.isChecked()){
                    Toast.makeText(MainActivity.this, "Burger is selected. Rs 80", Toast.LENGTH_SHORT).show();
                }
            }
        });
        c3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c3.isChecked()){
                    Toast.makeText(MainActivity.this, "Coke is selected. Rs 20", Toast.LENGTH_SHORT).show();
                }
            }
        });
        c4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c4.isChecked()){
                    Toast.makeText(MainActivity.this, "Fries is selected. Rs 50", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer s=new StringBuffer();

                if (c.isChecked()){
                    s.append("\nPizza is selected. Rs 100\n");

                }
                if (c2.isChecked()){
                    s.append("Burger is selected. Rs 80\n");

                }
                if (c3.isChecked()){
                    s.append("Coke is selected. Rs 20\n");

                }
                if (c4.isChecked()){
                    s.append("Fries is selected. Rs 50\n");

                }

                StringBuffer x=new StringBuffer();
                s.append(toggleButton.getText());


                int c=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(c);
                Toast.makeText(MainActivity.this, "The toggle button is "+x.toString()+s+"The extra you selected is "+radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
