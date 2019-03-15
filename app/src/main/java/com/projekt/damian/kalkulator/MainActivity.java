package com.projekt.damian.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InterruptedIOException;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextViev;
    private Integer counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mTextViev = findViewById(R.id.textView);

        counter = 0;
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                mTextViev.setText(counter.toString());
            }
        });

    }
}
