package com.vr1sh.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScientificActivity extends AppCompatActivity {

    Button bZero, bSin, bCos, bTan, bCot, bSec, bCsc, bLog, bSquare, bRoot, bPi, bE, bPlus, bMinus,
            bMultiply, bDivision, bEqual, bClear, bDot, bBracket, bBack;
    TextView tvInput,tvOutput;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bZero = findViewById(R.id.btn0);
        bSin = findViewById(R.id.btnSin);
        bCos = findViewById(R.id.btnCos);
        bTan = findViewById(R.id.btnTan);
        bCot = findViewById(R.id.btnCot);
        bSec = findViewById(R.id.btnSec);
        bCsc = findViewById(R.id.btnCsc);
        bLog = findViewById(R.id.btnLog);
        bSquare = findViewById(R.id.btnSquare);
        bRoot = findViewById(R.id.btnRoot);
        bPi = findViewById(R.id.btnPi);
        bE = findViewById(R.id.btnPlus);
        bMinus = findViewById(R.id.btnMinus);
        bDivision = findViewById(R.id.btnDivision);
        bMultiply = findViewById(R.id.btnMultiply);
        bEqual = findViewById(R.id.btnEqual);
        bClear = findViewById(R.id.btnClear);
        bDot = findViewById(R.id.btnDot);
        bBack = findViewById(R.id.btnBack);
        bBracket = findViewById(R.id.btnBracket);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

    }
    
}
