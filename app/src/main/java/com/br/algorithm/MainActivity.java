package com.br.algorithm;

import android.app.ActionBar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_algCode = (TextView) findViewById(R.id.tv_algCode);
        tv_algCode.setText(Html.fromHtml("<font color=\"#bdbdbd\"><i>//Algoritmo feito em C</i></font><br><br>" +
                "<font color=\"blue\">void</font> BubbleSort(<font color=\"blue\">int</font> vet[], <font color=\"blue\">int</font> tamanho) {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"blue\">if</font> (tamanho == <font color=\"#4169E1\">0</font>) {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"blue\">return</font>;<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"blue\">int</font> i = <font color=\"#4169E1\">0</font>;<br><br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"blue\">for</font> (i = <font color=\"#4169E1\">0</font>; i < tamanho - <font color=\"#4169E1\">1</font>; i++) {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (vet[i + <font color=\"#4169E1\">1</font>] < vet[<font color=\"#4169E1\">i</font>]) {<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"blue\">int</font> aux = vet[i+<font color=\"#4169E1\">1</font>];<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;vet[i + <font color=\"#4169E1\">1</font>] = vet[i];<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;vet[i] = aux;<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"blue\">return</font> BubbleSort(vet, tamanho - <font color=\"#4169E1\">1</font>);<br>" +
                "}"));
        getSupportActionBar().setTitle("Algoritmo Insertion Sort");

        Button bt_valor = (Button) findViewById(R.id.bt_valor);
        final EditText et_valores = (EditText) findViewById(R.id.et_valores);
        final TextView tv_valores = (TextView) findViewById(R.id.tv_valores);
        final TextView tv_ordenado = (TextView) findViewById(R.id.tv_ordenado);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        final ArrayList<Integer> valores = new ArrayList();
        final TextView valueTV = new TextView(MainActivity.this);
        final TextView tv_tempo = (TextView) findViewById(R.id.tv_tempo);

        bt_valor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_valores.getText().toString().length() == 0){
                    Toast.makeText(getBaseContext(), "Insira um valor para inserir", Toast.LENGTH_SHORT).show();
                    et_valores.requestFocus();
                }else{
                    int valor = Integer.parseInt(et_valores.getText().toString());
                    et_valores.setText("");
                    valores.add(valor);

                    String valArray = "";

                    for (Integer v:valores){
                        valArray = valArray + "   " + Integer.toString(v);
                        tv_valores.setText(valArray);
                    }
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

                String execução = BubbleSort(vet, tamArrayList);

                String valArray = "";

                for(i = 0; i < tamArrayList; i++) {
                    valArray = valArray + "   " + Integer.toString(vet[i]);
                    tv_ordenado.setText(valArray);
                }

                et_valores.clearFocus();

                if (valueTV.getText() == ""){
                    valueTV.setId(R.id.tv_textOrdenado);
                    valueTV.setText("Os valores ordenado são: ");
                    valueTV.setLayoutParams(new android.support.v7.app.ActionBar.LayoutParams(android.support.v7.app.ActionBar.LayoutParams.MATCH_PARENT,
                            android.support.v7.app.ActionBar.LayoutParams.WRAP_CONTENT));
                    RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    p.addRule(RelativeLayout.BELOW, R.id.tv_valores);
                    p.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    valueTV.setLayoutParams(p);
                    valueTV.setTextAppearance(getBaseContext(), R.style.styleTV);
                    relativeLayout.addView(valueTV);

                    TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.il_valores);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)textInputLayout.getLayoutParams();
                    params.addRule(RelativeLayout.BELOW, R.id.tv_ordenado);
                    textInputLayout.setLayoutParams(params);
                }
                tv_tempo.setText("Tempo = " + execução);
            }
        });
    }

    public native String BubbleSort(int vet[], int tamanho);
}


