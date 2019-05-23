package com.projekt.damian.kalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InterruptedIOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void simpleCalculatorActivity() {
        Intent intent = new Intent(this, SimpleCalculatorActivity.class);
        startActivity(intent);
    }

    private void advancedCalculatorActivity() {
        Intent intent = new Intent(this, AdvancedCalculatorActivity.class);
        startActivity(intent);
    }

    public void newActivity(View view) {
        switch (view.getId()) {
            case R.id.b_Simple:
                simpleCalculatorActivity();
                break;
            case R.id.b_Advanced:
                advancedCalculatorActivity();
                break;
        }
    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View view) {

        toastMsg("Damian Dłuski 202137");

    }

    public void exit(View view) {
        finish();
        System.exit(0);
    }
}



