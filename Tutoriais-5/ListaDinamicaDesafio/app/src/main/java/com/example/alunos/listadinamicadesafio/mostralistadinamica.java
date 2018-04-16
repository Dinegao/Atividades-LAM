package com.example.alunos.listadinamicadesafio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.alunos.listadinamicadesafio.adapter.PessoaAdapter;
import com.example.alunos.listadinamicadesafio.model.Pessoa;
import com.example.alunos.listadinamicadesafio.R;

import java.util.ArrayList;

public class mostralistadinamica extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_lista_dinamica);

        ListView listview = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try{
            ArrayList <Pessoa> lista = bundle.getParcelableArrayList("contatos");
            PessoaAdapter adapter = new PessoaAdapter(
                    mostralistadinamica.this, lista);
            listview.setAdapter(adapter);
        } catch(Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }
    }

}