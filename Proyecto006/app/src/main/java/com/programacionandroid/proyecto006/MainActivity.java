package com.programacionandroid.proyecto006;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
//import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String[]paises={"Paraguay","Argentina","Chile","Bolivia","Peru","Ecuador","Brasil",
            "Colombia","Venezuela","Uruguay"};
    private String[]habitantes={"6500000","40000000", "17000000","10000000", "30000000", "14000000",
            "183000000", "44000000","29000000", "3500000"};
    private TextView tv1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        lv1 =(ListView)findViewById(R.id.list1);
        ArrayAdapter <String>adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, paises);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                tv1.setText("Población de "+ lv1.getItemAtPosition(i) + " es "+
                        habitantes[i]);
            }
        });
    }
}