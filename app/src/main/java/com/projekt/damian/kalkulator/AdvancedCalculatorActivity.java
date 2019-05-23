package com.projekt.damian.kalkulator;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdvancedCalculatorActivity extends AppCompatActivity {


    Button btn7, btn8, btn9, btnDiv, btn4, btn5, btn6, btnMul
            , btn1, btn2, btn3, btnSub, btn0, btnDot, btn00, btnSum,
            btnC, btnChar, btnEqu, btnSqrt, btnLog, btnLn, btnSin, btnCos,
            btnTan, btnPer, btnX2, btnXY;
    TextView tvInput, tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_activity);

        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn00 = (Button) findViewById(R.id.btn_00);
        btnDiv = (Button) findViewById(R.id.btn_Div);
        btnMul = (Button) findViewById(R.id.btn_Mul);
        btnSub = (Button) findViewById(R.id.btn_Sub);
        btnDot = (Button) findViewById(R.id.btn_Dot);
        btnSum = (Button) findViewById(R.id.btn_Sum);
        btnC = (Button) findViewById(R.id.btn_C);
        btnChar = (Button) findViewById(R.id.btn_char);
        btnEqu = (Button) findViewById(R.id.btn_Equ);
        btnSqrt = (Button) findViewById(R.id.btn_sqrt);
        btnLog = (Button) findViewById(R.id.btn_log);
        btnLn = (Button) findViewById(R.id.btn_ln);
        btnSin = (Button) findViewById(R.id.btn_sin);
        btnCos = (Button) findViewById(R.id.btn_cos);
        btnTan = (Button) findViewById(R.id.btn_tan);
        btnPer = (Button) findViewById(R.id.btn_per);
        btnX2 = (Button) findViewById(R.id.btn_x2);
        btnXY = (Button) findViewById(R.id.btn_xy);

        tvInput = (TextView) findViewById(R.id.tv_input);
        tvResult = (TextView) findViewById(R.id.tv_result);

        clearScreen();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("0");
            }
        });
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("00");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("9");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("/");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("*");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("-");
            }
        });
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("+");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
            }
        });
        btnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("+/-");
            }
        });
        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("=");
            }
        });
        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("sqrt(");
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("log(");
            }
        });
        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("ln(");
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("sin(");
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("cos(");
            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("tan(");
            }
        });
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("%");
            }
        });
        btnX2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("^2");
            }
        });
        btnXY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExpression("^");
            }
        });



    }

    void clearScreen() {
        tvInput.setText("");
        tvResult.setText("0");
    }
    void inputExpression(String value){
        String expression = tvInput.getText().toString();
        expression = expression + value;

        tvInput.setText(expression);
    }
}
