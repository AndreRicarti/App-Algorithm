package com.br.algorithm;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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

        getSupportActionBar().setTitle("Algoritmo Insertion Sort");

        Button bt_valor = (Button) findViewById(R.id.bt_valor);
        final EditText et_valores = (EditText) findViewById(R.id.et_valores);
        final TextView tv_valores = (TextView) findViewById(R.id.tv_valores);
        final TextView tv_ordenado = (TextView) findViewById(R.id.tv_ordenado);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

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

                float execução = BubbleSort(vet, tamArrayList);

                String valArray = "";

                for(i = 0; i < tamArrayList; i++) {
                    valArray = valArray + "   " + Integer.toString(vet[i]);
                    tv_ordenado.setText(valArray);
                }

                et_valores.clearFocus();

                /*RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
                p.addRule(RelativeLayout.BELOW, R.id.below_id);
                viewToLayout.setLayoutParams(p);*/

                TextView valueTV = new TextView(MainActivity.this);
                valueTV.setId(R.id.tv_textOrdenado);
                valueTV.setText("Os valores ordenado são: ");
                valueTV.setLayoutParams(new android.support.v7.app.ActionBar.LayoutParams(android.support.v7.app.ActionBar.LayoutParams.MATCH_PARENT,
                        android.support.v7.app.ActionBar.LayoutParams.WRAP_CONTENT));
                RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                p.addRule(RelativeLayout.BELOW, R.id.bt_ordenar);
                p.addRule(RelativeLayout.CENTER_HORIZONTAL);
                valueTV.setLayoutParams(p);
                //valueTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.vinteum));
                valueTV.setTextAppearance(getBaseContext(), R.style.styleTV);
                relativeLayout.addView(valueTV);

            }
        });
    }
    public native int InsertionSort(int vet[], int tamanho);
    public native int BubbleSort(int vet[], int tamanho);
}


