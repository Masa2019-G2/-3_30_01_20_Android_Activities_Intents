package com.telran.a30_01_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        inputName = findViewById(R.id.inputName);
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.nextBtn){
            String name = inputName.getText().toString();
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("NAME",name);
//            startActivity(intent);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d("MY_TAG", "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
        if(resultCode == RESULT_OK && requestCode == 1){
            if (data != null) {
                String str = data.getStringExtra("DATA");
                Log.d("MY_TAG", "onActivityResult: " + str);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
