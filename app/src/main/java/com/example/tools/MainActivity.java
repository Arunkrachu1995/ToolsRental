package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tools.myapplication.R;


public class MainActivity extends AppCompatActivity {
    Button btn, dltbtn;
    EditText in1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btn);

        in1=(EditText) findViewById(R.id.editText);

        System.out.println("EDITTEXT: " + in1.getText().toString());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!in1.getText().toString().equals("")) {
                    nextPage(v);
                }
            else

            {
                Toast.makeText(getApplicationContext(), "Please enter valid ID", Toast.LENGTH_LONG).show();

            }
        }
        });

        dltbtn = findViewById(R.id.dltbtn);
        dltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!in1.getText().toString().equals("")) {

                    Intent myIntent=new Intent(MainActivity.this, deleteuser.class);
                    myIntent.putExtra("ID",(in1.getText().toString()));
                    startActivity(myIntent);

                }
                else

                {
                    Toast.makeText(getApplicationContext(), "Please enter valid ID", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    public void nextPage(View myView){

            Intent myIntent = new Intent(this, secondaries.class);
            myIntent.putExtra("ID", (in1.getText().toString()));
            startActivity(myIntent);


    }
}
