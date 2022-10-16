package com.programacionandroid.examenparcial_jeferzonsosa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private String[] frutas={"manzana","mandarina","pera","ceraza","Peru","durazno","fresa",
            "mango","platano","sandia"};
    private String[]precio={"5.999","5.500", "3.990","2.500", "1.900", "3.500",
            "7.400", "8.900","8.200", "1.500"};
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
                tv1.setText("Frutas de "+ lv1.getItemAtPosition(i) + " es "+
                        precio[i]);
            }
        });
    }
}