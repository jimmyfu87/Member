package com.example.member;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Forgetpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        final EditText etuseremail = (EditText) findViewById(R.id.email);
        final Button sendemail = (Button) findViewById(R.id.btn_sendEmail);

        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String useremail = etuseremail.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            String condition = jsonResponse.getString("condition");

                            if (condition .equals("sent")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Forgetpassword.this);
                                builder.setMessage("信件已寄發")
                                        .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(Forgetpassword.this, Log.class);
                                                Forgetpassword.this.startActivity(intent);
                                            }
                                        })
                                        .create()
                                        .show();

                            } else if(condition.equals("wrongformat")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Forgetpassword.this);
                                builder.setMessage("帳號為非信箱格式，寄發失敗")
                                        .setPositiveButton("知道了", null)
                                        .create()
                                        .show();
                            }
                            else  {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Forgetpassword.this);
                                builder.setMessage("此帳號未註冊，寄發失敗")
                                        .setPositiveButton("知道了", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ForgetRequest forgetRequest = new ForgetRequest(useremail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Forgetpassword.this);
                queue.add(forgetRequest);
            }
        });
    }




}
