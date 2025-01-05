package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        make variabla
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView textResult;
        LinearLayout llmain;

//        get weight
        edtWeight = findViewById(R.id.getWeight);
        edtHeightFt= findViewById(R.id.getHeightInFt);
        edtHeightIn= findViewById(R.id.getHeightInIn);
        btnCalculate= findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);
        llmain =findViewById(R.id.main);

//        work on button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt =Integer.parseInt(edtWeight.getText().toString());
                int htf = Integer.parseInt(edtHeightFt.getText().toString());
                int hti = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = htf*12 + hti;
                double totalCm= totalIn*2.53;
                double totalM= totalCm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    textResult.setText("You are over weight. You should go Gym. People call you Fat. Belive me, you are really fat ^_^");
                    llmain.setBackgroundColor(getResources().getColor(R.color.alart));
                } else if (bmi<18) {
                    textResult.setText("Your weight is too low. You should eat better food.");
                    llmain.setBackgroundColor(getResources().getColor(R.color.attention));
                }else {
                    textResult.setText("Your weight is perfect. Keep working. ^_^");
                    llmain.setBackgroundColor(getResources().getColor(R.color.good));
                }
            }
        });
    }
}