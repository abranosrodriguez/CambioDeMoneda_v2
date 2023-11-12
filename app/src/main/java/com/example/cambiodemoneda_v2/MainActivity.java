package com.example.cambiodemoneda_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton rdbPAE, rdbEAP;
    private RadioGroup rdbGroup;
    private EditText editTextValor;
    private Button btnCambiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdbPAE = findViewById(R.id.rdbPaE);
        rdbEAP = findViewById(R.id.rdbEaP);
        rdbGroup = findViewById(R.id.rdbGroup);
        editTextValor = findViewById(R.id.editTextValor);
        btnCambiar = findViewById(R.id.btnCambiar);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if(rdbGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MainActivity.this, "ERROR - Seleciona el tipo de cambio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}