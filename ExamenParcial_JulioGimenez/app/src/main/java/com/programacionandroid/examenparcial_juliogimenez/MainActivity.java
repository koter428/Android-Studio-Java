package com.programacionandroid.examenparcial_juliogimenez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] precios = { "3500","3000", "1000",
            "15000", "5000", "20000", "15000", "3500",
            "29000000", "3500000" };

    private String[] frutas = { "Manzana", "Naranja", "Banana", "Frutilla",
            "Piña", "Sandia", "Uva", "Pera" };

    private TextView tv1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.tv1);
        lv1 =(ListView)findViewById(R.id.list1);
        ArrayAdapter <String>adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, frutas);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                tv1.setText("El Precio de la " +lv1.getItemAtPosition(i)+ " es: "+precios[i]);
            }
        });
    }

}