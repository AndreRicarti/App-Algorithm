package com.br.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_valor = (Button) findViewById(R.id.bt_valor);
        final EditText et_valores = (EditText) findViewById(R.id.et_valores);
        final TextView tv_valores = (TextView) findViewById(R.id.tv_valores);
        final TextView tv_ordenado = (TextView) findViewById(R.id.tv_ordenado);

        final ArrayList<Integer> valores = new ArrayList();

        bt_valor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor = Integer.parseInt(et_valores.getText().toString());
                et_valores.setText("");
                valores.add(valor);

                String valArray = "";

                for (Integer v:valores){
                    valArray = valArray + "   " + Integer.toString(v);
                    tv_valores.setText(valArray);
                }
            }
        });

        Button bt_ordenar = (Button) findViewById(R.id.bt_ordenar);
        bt_ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tamArrayList = valores.size();
                int vet[] = new int[tamArrayList];

                int i = 0;

                for (Integer v:valores){
                    vet[i] = v;
                    i++;
                }

                BubbleSort(vet, tamArrayList);

                String valArray = "";

                for(i = 0; i < tamArrayList; i++) {
                    valArray = valArray + "   " + Integer.toString(vet[i]);
                    tv_ordenado.setText(valArray);
                }
            }
        });
    }

    public native int InsertionSort(int vet[], int tamanho);
    public native int BubbleSort(int vet[], int tamanho);
}


