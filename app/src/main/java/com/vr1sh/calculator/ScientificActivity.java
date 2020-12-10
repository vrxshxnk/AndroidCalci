package com.vr1sh.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class ScientificActivity extends AppCompatActivity {

    Button b0, bSin, bCos, bTan, bCot, bSec, bCsc, bLog, bSquare, bRoot, bPi, bE, bPlus, bMinus,
            bMultiply, bDivision, bEqual, bClear, bDot, bBracket, bBack;
    TextView tvInput,tvOutput;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        b0 = findViewById(R.id.btn0);
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

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });

        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });

        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "×");
            }
        });

        bDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "÷");
            }
        });

        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + ".");
            }
        });

        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();

                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                } catch (Exception e){
                    finalResult="0";
                }

                tvOutput.setText(finalResult);
            }
        });


    }

}
