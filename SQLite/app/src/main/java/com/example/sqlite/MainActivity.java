package com.example.sqlite;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText etRegNo, etName, etMarks;
    private Button btnAdd, btnView, btnUpdate, btnDelete;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        database = openOrCreateDatabase("Students", Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS student(regno VARCHAR, name VARCHAR, marks VARCAHR);");

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (TextUtils.isEmpty(etRegNo.getText().toString()))
                {
                    etRegNo.setError("Please enter register number");
                    return;
                } else if(TextUtils.isEmpty(etName.getText().toString()))
                {
                    etName.setError("Please enter name");
                    return;
                } else if(TextUtils.isEmpty(etMarks.getText().toString()))
                {
                    etMarks.setError("Please enter marks");
                    return;
                }
                else
                {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("regno", etRegNo.getText().toString());
                    contentValues.put("name", etName.getText().toString());
                    contentValues.put("marks", etMarks.getText().toString());

                    long mRes = database.insert("student", null, contentValues);
                    if (mRes != -1)
                    {
                        showMessage("Success",  "Record added");
                        clearText();
                    }
                    else
                    {
                        showMessage("OOPS",  "Record has not saved, Please try again");
                    }
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                if (TextUtils.isEmpty(etRegNo.getText().toString()))
                {
                    etRegNo.setError("Please enter register number");
                    return;
                }

                Cursor cursor = database.rawQuery("SELECT * FROM student WHERE regno = ?",
                        new String[]{etRegNo.getText().toString()}, null);

                if (cursor != null && cursor.getCount() > 0)
                {
                    if (cursor.moveToFirst())
                    {
                        do {
                            showMessage("Student Details", "Reg. No. : " + cursor.getString(0) + "\n" +
                                    "Name : " + cursor.getString(1) + "\n" + "Marks : " + cursor.getString(2));
                            clearText();
                        }
                        while (cursor.moveToNext());
                    }
                }
                else
                {
                    showMessage("OOps", "Haven't found any record with the provided reg number");
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (TextUtils.isEmpty(etRegNo.getText().toString()))
                {
                    etRegNo.setError("Please enter register number");
                    return;
                }
                else if(TextUtils.isEmpty(etName.getText().toString()))
                {
                    etName.setError("Please enter name");
                    return;
                }
                else if(TextUtils.isEmpty(etMarks.getText().toString()))
                {
                    etMarks.setError("Please enter marks");
                    return;
                } else
                {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("regno", etRegNo.getText().toString());
                    contentValues.put("name", etName.getText().toString());
                    contentValues.put("marks", etMarks.getText().toString());

                    long mRes = database.update("student", contentValues, "regno = ?", new String[]{etRegNo.getText().toString()});
                    if (mRes != -1)
                    {
                        showMessage("Success", "Record modified");
                        clearText();
                    }
                    else
                    {
                        showMessage("OOPS", "Record updation has been failed, please try again");
                    }
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                Cursor cursor = database.rawQuery("SELECT * FROM student WHERE regno = ?",
                        new String[]{etRegNo.getText().toString()}, null);

                if (cursor != null && cursor.getCount() > 0)
                {
                    if (cursor.moveToFirst())
                    {
                        do
                        {
                            long mRes = database.delete("student", "regno = ?", new String[]{etRegNo.getText().toString()});
                            if (mRes != -1)
                            {
                                showMessage("Success", "Record has been deleted successfully");
                                clearText();
                            }
                            else
                            {
                                showMessage("OOPS", "Record deletion has been failed, please try again");
                            }
                        }
                        while (cursor.moveToNext());
                    }
                }
                else
                {
                    showMessage("OOps", "Haven't found any record with the provided reg number");
                }
            }
        });
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        etRegNo.setText("");
        etName.setText("");
        etMarks.setText("");
    }
    private void init()
    {
        etRegNo = (EditText) findViewById(R.id.etReg);
        etName = (EditText) findViewById(R.id.etName);
        etMarks = (EditText) findViewById(R.id.etMarks);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
    }
}
