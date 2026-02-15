package com.example.parouimpar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    EditText numero;
    Button calcular;
    int ler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.textResultado);
        numero = findViewById(R.id.editNumero);
        calcular = findViewById(R.id.btnCalc);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ler = Integer.parseInt(numero.getText().toString().trim());

                    if (ler >= 0){
                        if ((ler&1 )== 0){
                            resultado.setText("O número é PAR");
                        } else {
                            resultado.setText("O número é IMPAR");
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Número inválido", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Digite um número válido", Toast.LENGTH_LONG).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}