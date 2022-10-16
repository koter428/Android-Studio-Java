package com.example.proyectotarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private TextView tv2, tv3;
    private int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String v = String.valueOf(prefe.getInt("puntos", 0));
        tv2.setText(v);
        numero = 1 + (int) (Math.random() * 50);
    }

    public void verificar(View v) {
        int valor = Integer.parseInt(et1.getText().toString());
        if (numero == valor) {
            int puntosactual = Integer.parseInt(tv2.getText()
                    .toString());
            puntosactual++;
            tv2.setText(String.valueOf(puntosactual));
            tv3.setText("Muy bien ganó. Ahora pienso otro numero");
            et1.setText("");
            SharedPreferences preferencias =getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putInt("puntos", puntosactual);
            editor.commit();
            numero = 1 + (int) (Math.random() * 50);
        } else {
            if (valor > numero) {
                tv3.setText("Ingreso un numero mayor al que penso la maquina.");
            } else {
                tv3.setText("Ingreso un numero menor al que penso la maquina.");
            }
        }
    }
}