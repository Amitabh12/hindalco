package com.example.amitabh.ps1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void new_request(View view)
    {
        Intent intent = new Intent(Main5Activity.this, Main2Activity.class);
        startActivity(intent);
    }


}
