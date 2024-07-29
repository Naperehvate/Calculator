package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView resultField;
    TextView operationField;
    EditText numberField;
    Double operand = null;
    String lastOperation = "=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField = findViewById(R.id.resultField);
        operationField = findViewById(R.id.operationField);
        numberField = findViewById(R.id.numberField);
        findViewById(R.id.btnadd).setOnClickListener(view -> onOperationClick("+"));
        findViewById(R.id.btnsub).setOnClickListener(view -> onOperationClick("-"));
        findViewById(R.id.btnmult).setOnClickListener(view -> onOperationClick("*"));
        findViewById(R.id.btndiv).setOnClickListener(view -> onOperationClick("/"));
        findViewById(R.id.btnres).setOnClickListener(view -> onOperationClick("="));
        findViewById(R.id.btn0).setOnClickListener(view -> onNumberClick("0"));
        findViewById(R.id.btn1).setOnClickListener(view -> onNumberClick("1"));
        findViewById(R.id.btn2).setOnClickListener(view -> onNumberClick("2"));
        findViewById(R.id.btn3).setOnClickListener(view -> onNumberClick("3"));
        findViewById(R.id.btn4).setOnClickListener(view -> onNumberClick("4"));
        findViewById(R.id.btn5).setOnClickListener(view -> onNumberClick("5"));
        findViewById(R.id.btn6).setOnClickListener(view -> onNumberClick("6"));
        findViewById(R.id.btn7).setOnClickListener(view -> onNumberClick("7"));
        findViewById(R.id.btn8).setOnClickListener(view -> onNumberClick("8"));
        findViewById(R.id.btn9).setOnClickListener(view -> onNumberClick("9"));
        findViewById(R.id.btndot).setOnClickListener(view -> onNumberClick("."));
    }
}