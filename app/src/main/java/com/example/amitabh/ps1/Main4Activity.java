package com.example.amitabh.ps1;





import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Main4Activity extends AppCompatActivity {


    private TextView quat_no;
    private EditText req;
    private int flag=0;
    private Button proceed_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        proceed_btn=(Button) findViewById(R.id.prcd_btn);
        quat_no = (TextView) findViewById(R.id.quarter_no);

        req = (EditText) findViewById(R.id.request_text);



    }

    public void send_form(View view)
    {

        String q_no = quat_no.getText().toString();

        String r_text = req.getText().toString();

        if (TextUtils.isEmpty(q_no)) {
            req.setError(getString(R.string.error_field_required));
        }


       if (TextUtils.isEmpty(r_text)) {
            req.setError(getString(R.string.error_field_required));
        }

        //get message from message box


          if((!TextUtils.isEmpty(q_no))&&(!TextUtils.isEmpty(r_text)))
          {
              flag=1;
              req.setError(null);
              Intent intent = new Intent(Intent.ACTION_SENDTO);
              intent.setData(Uri.parse("mailto:"));
              intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"amitabhworkacer@gmail.com"});
              intent.putExtra(Intent.EXTRA_SUBJECT, q_no);
              intent.putExtra(Intent.EXTRA_TEXT, r_text);
              try {
                  startActivity(Intent.createChooser(intent, "Send mail..."));
              } catch (android.content.ActivityNotFoundException ex) {
                  Toast.makeText(Main4Activity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
              }


          }



    }
    public void request_number(View view) {
        if(flag==0){
            req.setError("First submit request after filling this field");
        }
        if (flag==1) {

            Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
            startActivity(intent);
        }
    }


}
