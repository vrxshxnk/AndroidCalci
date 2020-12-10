package com.vr1sh.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class ScientificActivity extends AppCompatActivity {

    Button bPlus, bMinus, bMultiply, bDivision, bEqual, bClear, bDot, bBracket, bBack, bSin, bCos,
            bTan, bCot, bSec, bCsc, bLog, bSquare, bRoot, bFact, bMain;

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
        bMain = findViewById(R.id.btnMain);
        bClear = findViewById(R.id.btnClear);
        bPlus = findViewById(R.id.btnPlus);
        bMinus = findViewById(R.id.btnMinus);
        bDivision = findViewById(R.id.btnDivision);
        bMultiply = findViewById(R.id.btnMultiply);
        bEqual = findViewById(R.id.btnEqual);
        bDot = findViewById(R.id.btnDot);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        Bundle bundle = getIntent().getExtras();
        String tvi = bundle.getString("tvi");
        String tvo = bundle.getString("tvo");
        tvOutput.setText(tvo);
        tvInput.setText(tvi);

        bMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = tvInput.getText().toString();
                String output = tvOutput.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("tvi", input);
                bundle.putString("tvo", output);
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

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BackSpace= null;
                if(tvInput.getText().length()>0) {
                    StringBuilder stringBuilder = new StringBuilder(tvInput.getText());
                    stringBuilder.deleteCharAt(tvInput.getText().length() - 1);
                    BackSpace = stringBuilder.toString();
                    tvInput.setText(BackSpace);
                }
            }
        });

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "+");
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

        bSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double input = Double.parseDouble(tvInput.getText().toString());
                Double input1 = Math.sin(input);
                process = input1.toString();
                tvInput.setText("sin: " + process);
            }
        });

        bCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double input = Double.parseDouble(tvInput.getText().toString());
                Double input1 = Math.cos(input);
                process = input1.toString();
                tvInput.setText("cos: " + process);
            }
        });

        bTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double input= Double.parseDouble(tvInput.getText().toString());
                Double input1 = Math.tan(input);
                process = input1.toString();
                tvInput.setText("tan:" + process);
            }
        });

        bRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double input = Double.parseDouble(tvInput.getText().toString());
                Double input1 = Math.sqrt(input);
                process = input1.toString();
                tvInput.setText("root:" + process);
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




