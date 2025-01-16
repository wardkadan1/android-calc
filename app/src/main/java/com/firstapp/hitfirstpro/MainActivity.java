package com.firstapp.hitfirstpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private double number1;
    private double number2;
    private char ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result= findViewById(R.id.textView);
        result.setText("");
    }




    public void numFunch(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void calculate(View view) {
        if (result.getText().toString().isEmpty()) return;
        number2 = Double.parseDouble(result.getText().toString());
        double output = 0;

        switch (ch) {
            case '+':
                output = number1 + number2;
                break;
            case '-':
                output = number1 - number2;
                break;
            case '*':
                output = number1 * number2;
                break;
            case '/':
                output = number2 != 0 ? number1 / number2 : 0;
                break;
        }

        result.setText(String.valueOf(output));
    }

    public void opfunch(View view) {
        if (result.getText().toString().isEmpty()) return;
        number1 = Double.parseDouble(result.getText().toString());
        Button button = (Button) view;
        ch = button.getText().toString().charAt(0);
        result.setText("");
    }

    public void clear(View view) {
        result.setText("");
        number1 = 0;
        number2 = 0;
        ch = '\0';
    }
}