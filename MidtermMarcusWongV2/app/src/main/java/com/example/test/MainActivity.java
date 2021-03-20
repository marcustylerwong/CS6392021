package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText1;
    private TextView mTextviewResults;
    private Button mButtonMultiply;
    private String Euro = " Euros";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = findViewById(R.id.editText_number);
        mTextviewResults = findViewById(R.id.textView_result);
        mButtonMultiply = findViewById(R.id.button);

        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText1.getText().toString().length()== 0){
                    mEditText1.setText("0");
                }

                float num1 = Float.parseFloat(mEditText1.getText().toString());
                float result = (float) (num1 * 0.88);
                //mTextviewResults.setText(String.format("%2f",result));
                //mTextviewResults.setText(new DecimalFormat("##.##").format(result));
                mTextviewResults.setText(result + Euro);
            }
        });




    }
}