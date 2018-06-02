package com.example.amitabh.ps1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    Spinner sr_area;
    Spinner sr_cat;
    Spinner sr_type;
    Spinner sr_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sr_area = (Spinner) findViewById(R.id.service_area);
        sr_cat= (Spinner) findViewById(R.id.service_category);
        sr_type=(Spinner) findViewById(R.id.service_type);




        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> service_ar = databaseAccess.getServiceArea();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,service_ar );
        sr_area.setAdapter(adapter);

    }








    public void submit_request(View view)
    {
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        startActivity(intent);
    }


}


