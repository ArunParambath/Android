package com.example.lmel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private EditText et_Name;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2;
    private RatingBar ratingBar;
    private Button btn_submit;

    private String name, gender, dept;
    private float prog;

    String mGenderList[] = {"Male", "Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter mListAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,mGenderList);
        mListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(mListAdapter);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if (radioButton1.isChecked())
                {
                    dept = radioButton1.getText().toString();
                }
                if (radioButton2.isChecked())

                {
                    dept = radioButton2.getText().toString();
                }
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromuser)
            {
                prog = rating;
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name = et_Name.getText().toString();
                gender = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Name :" + name + "\n Gender :" + gender + "\n Degree :" + dept +"\n Programming Knowledge : "+ prog, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void init()
    {
        et_Name = (EditText) findViewById(R.id.editText);
        spinner = (Spinner) findViewById(R.id.spinner);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btn_submit = (Button) findViewById(R.id.button);
    }
}
