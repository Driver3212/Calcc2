package com.example.myapplicationj10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        tvResult = findViewById(R.id.tvResult);

        Button bt1 = findViewById(R.id.btPlus);
        Button bt2 = findViewById(R.id.btMinus);
        Button bt3 = findViewById(R.id.btMul);
        Button bt4 = findViewById(R.id.btDiv);

        bt1.setOnClickListener(x -> calculate('+'));
        bt2.setOnClickListener(x -> calculate('-'));
        bt3.setOnClickListener(x -> calculate('*'));
        bt4.setOnClickListener(x -> calculate('/'));
    }

    void calculate(char operation) {
        double a, b;
        try {
            a = Double.parseDouble(editText1.getText().toString());
            b = Double.parseDouble(editText2.getText().toString());
        } catch (NumberFormatException e) {
            tvResult.setText("Введите оба числа");
            return;
        }

        double result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    tvResult.setText("Деление на ноль невозможно");
                    return;
                }
                result = a / b;
                break;
            default:
                return;
        }

        tvResult.setText(String.valueOf(result));
    }
}