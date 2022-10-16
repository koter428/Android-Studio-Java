package com.programacionandroid.examenparcial_alanisnuez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private String[] frutas={"banana","toronga","uva","aguacate","kiwi","limon","papaya",
            "coco","ciruela","piña"};
    private String[]precio={"6.900","7.200", "10.990",".8.500", "3.900", "4.500",
            "8.400", "6.900","9.200", "11.500"};
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