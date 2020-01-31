package com.telran.a30_01_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button backBtn = findViewById(R.id.backButton);
        final Intent intent = getIntent();

//        Bundle extras = intent.getExtras();
        String name = intent.getStringExtra("NAME");
        TextView resultTxt = findViewById(R.id.resultTxt);
        Log.d("MY_TAG", "onCreate: " + name);
        if(name != null){
            resultTxt.setText(name);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
//                startActivity(intent);
                Intent data = new Intent();
                data.putExtra("DATA","Data from second Activity");
                setResult(RESULT_OK,data);
                finish();
            }
        });

    }
}
