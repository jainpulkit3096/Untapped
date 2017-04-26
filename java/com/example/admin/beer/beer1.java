package com.example.admin.beer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class beer1 extends Activity {
    EditText GetName,GetPhoneNumber,GetSubject ;
    Button Submit, ShowValues;
    SQLiteDatabase SQLITEDATABASE;
    String Name, PhoneNumber, Subject ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer1);

        GetName = (EditText)findViewById(R.id.editText1);

        GetPhoneNumber = (EditText)findViewById(R.id.editText2);

        GetSubject = (EditText)findViewById(R.id.editText3);

        Submit = (Button)findViewById(R.id.button1);

        ShowValues = (Button)findViewById(R.id.button2);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });

        ShowValues.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(beer1.this, ListViewActivity.class);
                startActivity(intent);

            }
        });
    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, phone_number VARCHAR, subject VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = GetName.getText().toString();

        PhoneNumber = GetPhoneNumber.getText().toString();

        Subject = GetSubject.getText().toString();

        CheckEditTextIsEmptyOrNot( Name,PhoneNumber, Subject);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO demoTable (name,phone_number,subject) VALUES('"+Name+"', '"+PhoneNumber+"', '"+Subject+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(beer1.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(beer1.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name,String PhoneNumber, String subject ){

        if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(PhoneNumber) || TextUtils.isEmpty(Subject)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        GetName.getText().clear();
        GetPhoneNumber.getText().clear();
        GetSubject.getText().clear();

    }

}