package com.projekt.damian.kalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AdvancedCalculatorActivity extends AppCompatActivity {

    TextView tvInput, tvResult;

    private Calculate calculate;
    private Toast toast;
    private final String TOAST = "Wrong operation";


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ArrayList<String> arrayList = savedInstanceState.getStringArrayList("backup");
        tvInput.setText(arrayList.get(0));
        tvResult.setText(arrayList.get(1));
        calculate.setStringBuilder(arrayList.get(1));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("backup", new ArrayList<String>(Arrays.asList(tvInput.getText().toString(),tvResult.getText().toString())));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_activity);
        tvInput = (TextView) findViewById(R.id.tv_input);
        tvResult = (TextView) findViewById(R.id.tv_result);
        toast = Toast.makeText(getApplicationContext(), TOAST, Toast.LENGTH_LONG);
        calculate = new Calculate(tvInput,tvResult,toast);


    }
    public void number(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                calculate.makeNumber("0");
                break;
            case R.id.btn_00:
                calculate.makeNumber("00");
                break;
            case R.id.btn_1:
                calculate.makeNumber("1");
                break;
            case R.id.btn_2:
                calculate.makeNumber("2");
                break;
            case R.id.btn_3:
                calculate.makeNumber("3");
                break;
            case R.id.btn_4:
                calculate.makeNumber("4");
                break;
            case R.id.btn_5:
                calculate.makeNumber("5");
                break;
            case R.id.btn_6:
                calculate.makeNumber("6");
                break;
            case R.id.btn_7:
                calculate.makeNumber("7");
                break;
            case R.id.btn_8:
                calculate.makeNumber("8");
                break;
            case R.id.btn_9:
                calculate.makeNumber("9");
                break;
            case R.id.btn_Dot:
                calculate.makeNumber(".");
                break;

        }
    }
    public void simple(View view) {
        switch (view.getId()) {
            case R.id.btn_Sum:
                calculate.clickOperator("+");
                break;
            case R.id.btn_Sub:
                calculate.clickOperator("-");
                break;
            case R.id.btn_Mul:
                calculate.clickOperator("*");
                break;
            case R.id.btn_Div:
                calculate.clickOperator("/");
                break;
            case R.id.btn_char:
                calculate.clickOperator("+/-");
                break;
            case R.id.btn_xy:
                calculate.clickOperator("^");
                break;

        }
    }
    public void advanced(View view) {
        switch (view.getId()) {
            case R.id.btn_sin:
                calculate.func("sin(");
                break;
            case R.id.btn_cos:
                calculate.func("cos(");
                break;
            case R.id.btn_tan:
                calculate.func("tan(");
                break;
            case R.id.btn_ln:
                calculate.func("ln(");
                break;
            case R.id.btn_log:
                calculate.func("log10(");
                break;
            case R.id.btn_sqrt:
                calculate.func("sqrt(");
                break;
            case R.id.btn_x2:
                calculate.func("^2");
                break;
        }
    }
    public void square(View v){
        calculate.square();
    }

    public void percent(View v) {
        calculate.percent();
    };

    public void delete(View v) {
        calculate.delete();
    }

    public void sum(View v) {
        calculate.sum();
    }

    public void plusMinus(View v) {
        calculate.plusMinus();
    }

    void clearScreen() {
        tvInput.setText("");
        tvResult.setText("0");
    }


}
