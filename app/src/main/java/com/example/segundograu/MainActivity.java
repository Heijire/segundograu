package com.example.segundograu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView tvdelta;
    private TextView tverrado;
    private TextView tvx1;
    private TextView tvx2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Tvx2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etA = findViewById(R.id.etA);
        etA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvdelta = findViewById(R.id.tvdelta);
        tvdelta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tverrado= findViewById(R.id.tverrado);
        tverrado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvx1 = findViewById(R.id.tvx1);
        tvx1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvx2 = findViewById(R.id.Tvx2);
        tvx2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.bntCal);
        btnCalc.setOnClickListener(op -> calc());

    }
    private void calc(){
        double a = Double.parseDouble(etA.getText().toString());
        double b = Double.parseDouble(etB.getText().toString());
        double c = Double.parseDouble(etC.getText().toString());
        double delta = (Math.pow( b , 2 )) - ( 4 * a * c );
        if(a == 0){
            String erra =  getString(R.string.erro) +"Essa equação nao é de 2 grau" ;
            tverrado.setText(erra);
            String resx1 = " ";
            tvx1.setText(resx1);
            String resx2 = " ";
            tvx2.setText(resx2);
            String del = " ";
            tvdelta.setText(del);
        } else if (delta < 0) {
            String erra =  getString(R.string.erro) +"Não possui raiz real";
            tverrado.setText(erra);
            String del = getString(R.string.delta) + " " + delta;
            tvdelta.setText(del);
            tverrado.setText(erra);
            String resx1 = " ";
            tvx1.setText(resx1);
            String resx2 = " ";
            tvx2.setText(resx2);
        } else {
            double x1 = (-b + (Math.sqrt(delta))) / (2 * a);
            double x2 = (-b - (Math.sqrt(delta))) / (2 * a);
            String resx1 = getString(R.string.x1) + " " + x1;
            tvx1.setText(resx1);
            String resx2 = getString(R.string.x2) + " " + x2;
            tvx2.setText(resx2);
            String del = getString(R.string.delta) + " " + delta;
            tvdelta.setText(del);
            String erra = "     ";
            tverrado.setText(erra);
        }
    }
}