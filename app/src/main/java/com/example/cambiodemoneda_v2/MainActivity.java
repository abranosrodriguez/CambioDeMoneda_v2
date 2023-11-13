package com.example.cambiodemoneda_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private String stringEditTextValor,textoAPasar;
    private double valorEditTextValor, valorCalculado;
    private double valorPesetasUnEuro = 1538.82;
    private double valorPesetas = 0.00065;
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
                stringEditTextValor =editTextValor.getText().toString();
                if(stringEditTextValor.isEmpty()){
                    Toast.makeText(MainActivity.this, "ERROR - Introduce un Valor", Toast.LENGTH_SHORT).show();
                }else if(rdbGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MainActivity.this, "ERROR - Seleciona el tipo de cambio", Toast.LENGTH_SHORT).show();
                }else{
                    valorEditTextValor = Double.parseDouble(stringEditTextValor);
                    if (rdbPAE.isChecked()) {
                        //1538,82pesetas el precio de 1€
                        valorCalculado = valorPesetas * valorEditTextValor ;
                        textoAPasar = (valorEditTextValor +" pesetas son " + valorCalculado + " euros");
                    } else if (rdbEAP.isChecked()) {
                        valorCalculado = valorEditTextValor * valorPesetasUnEuro;
                        textoAPasar = (valorEditTextValor +" euros son " + valorCalculado + " pesetas");
                    }
                    cambiarMenuAMoneda(view);
                }

            }
        });

    }
    public void cambiarMenuAMoneda(View v){
        Intent intent = new Intent(this, cambioMoneda.class);
        intent.putExtra("text",textoAPasar);
        startActivity(intent);

    }
}