package com.example.alunos.jogotentativa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rank extends AppCompatActivity {

    Intent intencao;
    Bundle pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rank);
        TextView rank = (TextView) findViewById(R.id.textViewPontos);
        String conteudo = "";
        intencao = getIntent();
        pacote = intencao.getExtras();
        int[] tentativas = new int[5];
        String num, melhor;

        tentativas = pacote.getIntArray("tentativas");


        for(int i=4;i>=0; i--){
            num =  Integer.toString(tentativas[i]);
            conteudo += num + "\n";
        }
        melhor =Integer.toString(pacote.getInt("melhor"));
        conteudo += "Melhor Tentativa: " + melhor ;
        rank.setText(conteudo);

    }
}