package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;


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

    public void onNumberClick(String number) {
        numberField.append(number);
        if(lastOperation.equals("=") && operand != null) {
            operand = null;
        }
    }
    public void onOperationClick(String operation) {
        String number = numberField.getText().toString();
        if(number.length() > 0) {
            number = number.replace(",", ".");
            try {
                performOperation(Double.valueOf(number), operation);
            } catch (Exception e) {
                numberField.setText("");
            }
        }
        lastOperation = operation;
        operationField.setText(lastOperation);
    }
    private void performOperation(Double number, String operation) {
        if(operand == null) {
            operand = number;
        }
        else {
            if(lastOperation.equals("=")) {
                lastOperation = operation;
            }
            switch(lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if(number == 0) {
                        operand = 0.0;
                    }
                    else {
                        operand /= number;
                    }
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
                default:
                    break;
            }
        }
        resultField.setText(operand.toString().replace(",", "."));
        numberField.setText("");
    }

    //сохранение состояния приложения при сворачивании, изменении ориентации, блокировке и тд.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if(operand != null) {
            outState.putDouble("OPERAND", operand);
        }
        super.onSaveInstanceState(outState);
    }
    //восстановление состояние после продолжения работы приложения/смены ориентации
    @Override
    protected void onRestoreInstanceState(@NotNull Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        lastOperation = savedState.getString("OPERATION");
        operand = savedState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);
    }


}