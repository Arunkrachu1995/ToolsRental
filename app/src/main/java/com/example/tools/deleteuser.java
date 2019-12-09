package com.example.tools;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tools.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class deleteuser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        new MyTask().execute();
    }

private class MyTask extends AsyncTask<Void,Void,Void> {


    String message;


        @Override
        protected Void doInBackground(Void... params) {
            URL url=null;
            Intent myNewIntent=getIntent();
            String InfoReceivedId=myNewIntent.getStringExtra("ID"  );
            try{
                url=new URL("http://192.168.2.84:8080/webservicecalls/webresources/toolrental/user1/deleteuser&"+InfoReceivedId);
                HttpURLConnection client=null;
                client=(HttpURLConnection) url.openConnection();
                client.setRequestMethod("GET");
                int responseCode=client.getResponseCode();
                System.out.println("\n Sending 'GET' request to URL: "+url);
                System.out.println("Response code : responseCode");
                InputStreamReader myInput=new InputStreamReader(client.getInputStream());
                BufferedReader in=new BufferedReader(myInput);
                String inputLine;
                StringBuffer response=new StringBuffer();
                while((inputLine=in.readLine())!=null){
                    response.append(inputLine);
                }
                in.close();
                //print result
                System.out.println(response.toString());

                JSONObject obj=new JSONObject  (response.toString());


                message=obj.getString("Message");
            }
            catch(MalformedURLException e)
            {
                e.printStackTrace();


            }
            catch(IOException e)
            {
                e.printStackTrace();

            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
            return null;

        }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        Intent i = new Intent(deleteuser.this, MainActivity.class);
        startActivity(i);

        super.onPostExecute(aVoid);
    }
}
}
