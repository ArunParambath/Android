package com.example.passwordtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private EditText pass_word;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        pass_word=(EditText)findViewById(R.id.passwd);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                Toast.makeText(MainActivity.this,pass_word.getText(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
