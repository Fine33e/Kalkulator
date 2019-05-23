package com.projekt.damian.kalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleCalculatorActivity extends AppCompatActivity {
    private TextView mEditText;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAdd;
    private Button buttonSub;
    private Button buttonMul;
    private Button buttonDivision;
    private Button buttonEqual;
    private Button button10;
    private Button buttonC;
    private Button button00;
    private Button buttonchr;
    private Float mValueOne;
    private boolean mSubtract;
    private boolean mMultiplication;
    private boolean mDivision;
    private Float mValueTwo;
    private boolean mAddition;
    private boolean mDot = false;
    private boolean mChr = false;
    private boolean mEqual = false;
    private double counter = 0;
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ArrayList<String> arrayList = savedInstanceState.getStringArrayList("backup");
        mEditText.setText(arrayList.get(0));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("backup", new ArrayList<>(Arrays.asList(mEditText.getText().toString())));
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_activity);

        buttonchr = findViewById(R.id.btn_char);
        button00 = findViewById(R.id.btn_00);
        button0 = findViewById(R.id.btn_0);
        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);
        button4 = findViewById(R.id.btn_4);
        button5 = findViewById(R.id.btn_5);
        button6 = findViewById(R.id.btn_6);
        button7 = findViewById(R.id.btn_7);
        button8 = findViewById(R.id.btn_8);
        button9 = findViewById(R.id.btn_9);
        buttonAdd = findViewById(R.id.btn_Sum);
        buttonSub = findViewById(R.id.btn_Sub);
        buttonMul = findViewById(R.id.btn_Mul);
        button10 = findViewById(R.id.btn_Dot);
        buttonDivision = findViewById(R.id.btn_Div);
        buttonC = findViewById(R.id.btn_C);
        buttonEqual = findViewById(R.id.btn_Equ);
        mEditText = findViewById(R.id.tv_result);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9) {
                    mEditText.setText(mEditText.getText() + "1");
                    mChr = true;
                    counter++;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9) {
                    mEditText.setText(mEditText.getText() + "2");
                    mChr = true;
                    counter++;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9) {
                    mEditText.setText(mEditText.getText() + "3");
                    mChr = true;
                    counter++;
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9) {
                    mEditText.setText(mEditText.getText() + "4");
                    mChr = true;
                    counter++;
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9) {
                    mEditText.setText(mEditText.getText() + "5");
                    mChr = true;
                    counter++;
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 9) {
                    mEditText.setText(mEditText.getText() + "6");
                    mChr = true;
                    counter++;
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 9) {
                    mEditText.setText(mEditText.getText() + "7");
                    mChr = true;
                    counter++;
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 9) {
                    mEditText.setText(mEditText.getText() + "8");
                    mChr = true;
                    counter++;
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 9) {
                    mEditText.setText(mEditText.getText() + "9");
                    mChr = true;
                    counter++;
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9) {
                    if (!mEditText.getText().equals("0")) {
                        mEditText.setText(mEditText.getText() + "0");
                        mChr = true;
                        counter++;
                    }
                }
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<9){
                if(!mEditText.getText().equals("")&&!mEditText.getText().equals("0")) {
                    mEditText.setText(mEditText.getText() + "00");
                    mChr = true;
                    counter++;
                    counter++;
                }
                }
            }

        });

        buttonchr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChr == false && mEqual == false) {
                    mEditText.setText(mEditText.getText() + "-");
                    mChr = true;
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEditText.getText().equals("")) {
                    if (mEditText == null) {
                        mEditText.setText("");
                    } else {
                        mValueOne = Float.parseFloat(mEditText.getText() + "");
                        mAddition = true;
                        mEditText.setText(null);
                        counter =0;
                    }
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEditText.getText().equals("")) {
                    mValueOne = Float.parseFloat(mEditText.getText() + "");
                    mSubtract = true;
                    mEditText.setText(null);
                    counter = 0;
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEditText.getText().equals("")) {
                    mValueOne = Float.parseFloat(mEditText.getText() + "");
                    mMultiplication = true;
                    mEditText.setText(null);
                    counter=0;
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEditText.getText().equals("")) {
                    mValueOne = Float.parseFloat(mEditText.getText() + "");
                    mDivision = true;
                    mEditText.setText(null);
                    counter=0;
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditText.getText().equals("")) {
                    mEditText.setText(mEditText.getText() + "0.");
                    mDot = true;
                }else {
                    if (mDot == false && mEqual == false) {
                        mEditText.setText(mEditText.getText() + ".");
                        mDot = true;
                    }
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
                mDot = false;
                mChr = false;
                mEqual = false;
                counter=0;
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEditText.getText().equals("")) {
                    mValueTwo = Float.parseFloat(mEditText.getText() + "");
                    counter=0;
                    if (mAddition == true) {
                        mEditText.setText(mValueOne + mValueTwo + "");
                        mAddition = false;
                        mDot = false;
                        mEqual = true;
                    }

                    if (mSubtract == true) {
                        mEditText.setText(mValueOne - mValueTwo + "");
                        mSubtract = false;
                        mDot = false;
                        mEqual = true;
                    }

                    if (mMultiplication == true) {
                        mEditText.setText(mValueOne * mValueTwo + "");
                        mMultiplication = false;
                        mDot = false;
                        mEqual = true;
                    }

                    if (mDivision == true) {
                        if (mValueTwo > 0) {
                            mEditText.setText(mValueOne / mValueTwo + "");
                            mDivision = false;
                            mDot = false;
                            mEqual = true;
                        } else {
                            toastMsg("nie dziel przez 0");
                        }

                    }
                }
            }
        });


    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
}


