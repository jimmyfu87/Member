package com.example.member;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
        final EditText username=(EditText) findViewById(R.id.id);
        final EditText password=(EditText) findViewById(R.id.password);
        final Button blogin=(Button)findViewById(R.id.Log);
        final Button reg=(Button)findViewById(R.id.Reg);

    reg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent registerIntent=new Intent(Log.this,Register.class);
            Log.this.startActivity(registerIntent);
        }
    });


    }
}
