package com.vr1sh.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScientificActivity extends AppCompatActivity {

    Button bPlus, bMinus, bMultiply, bDivision, bEqual, bClear, bDot, bBracket, bBack, bSin, bCos,
            bTan, bCot, bSec, bCsc, bLog, bSquare, bRoot, bE, bFact, bMain;

    TextView tvInput,tvOutput;
    String process;
    boolean checkBracket = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        bBracket = findViewById(R.id.btnBracket);
        bBack = findViewById(R.id.btnBack);
        bSin = findViewById(R.id.btnSin);
        bCos = findViewById(R.id.btnCos);
        bTan = findViewById(R.id.btnTan);
        bCot = findViewById(R.id.btnCot);
        bSec = findViewById(R.id.btnSec);
        bCsc = findViewById(R.id.btnCsc);
        bLog = findViewById(R.id.btnLog);
        bSquare = findViewById(R.id.btnSquare);
        bRoot = findViewById(R.id.btnRoot);
        bE = findViewById(R.id.btnPlus);
        bMain = findViewById(R.id.btnMain);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("tv");
        tvInput.setText(value);

        bMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = tvInput.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("tv", input);
                Intent i = new Intent(ScientificActivity.this, HomeActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        bBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    process = tvInput.getText().toString();
                    tvInput.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }
            }
        });


    }
}




