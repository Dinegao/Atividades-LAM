package com.example.alunos.jogotentativa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Random gerador = new Random();
    private int numero = gerador.nextInt(10) + 1;
    private int tentativas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Jogar(View V ) {
        this.tentativas++;
        EditText entrada = (EditText) findViewById(R.id.editText);
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        String ns = entrada.getText().toString();
        int n = Integer.parseInt(ns);
        if(n == this.numero) {
            etiqueta.setText(getResources().getString(R.string.lblGanhou));
            atualiza_dados();
        } else {
            if(n < this.numero){
                etiqueta.setText("É maior!");
            } else if(n > this.numero) {
                etiqueta.setText("É menor!");
            }
        }
    }

    public void atualiza_dados(){
        SharedPreferences arquivos = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivos.edit();
        int melhor = arquivos.getInt("melhor", 0);
        String key;
        if(melhor == 0 ){
            editor.putInt("melhor" , this.tentativas);
        } else {
            if (this.tentativas < melhor) {
                editor.putInt("melhor", this.tentativas);
            }
        }
        int[] j = new int[5];
        for (int i=0; i<5; i++){
            j[i] = 0;
        }
        for(int i=0; i<5; i++){
            key = Integer.toString(i);
            j[i] = arquivos.getInt(key, 0);
        }
        for(int i = 0; i<4; i++){
            j[i] = j[i+1];
        }
        j[4] = this.tentativas;
        for(int i=0; i<5; i++){
            key = Integer.toString(i);
            editor.putInt(key, j[i]);
        }


        editor.commit();
    }

    public void rank(View V){
        SharedPreferences arquivos = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivos.edit();
        Intent i =  new Intent(MainActivity.this, Rank.class);
        Bundle bundle = new Bundle();
        String key;
        int[] j = new int[5];
        int melhor = arquivos.getInt("melhor", 0);
        for(int k=0; k<5; k++){
            key = Integer.toString(k);
            j[k] = arquivos.getInt(key, 0);
        }
        bundle.putIntArray("tentativas", j);
        bundle.putInt("melhor", melhor);
        i.putExtras(bundle);
        startActivity(i);
    }


    public void Resetar(View V){
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        EditText entrada = (EditText) findViewById(R.id.editText);
        etiqueta.setText("");
        entrada.setText("");
        this.numero = gerador.nextInt(9) + 1;
        this.tentativas = 0;
    }
}