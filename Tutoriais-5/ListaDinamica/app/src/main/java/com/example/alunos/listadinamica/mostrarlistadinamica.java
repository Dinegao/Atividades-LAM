package com.example.alunos.listadinamica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alunos.listadinamica.adapter.PessoaAdapter;
import com.example.alunos.listadinamica.model.Pessoa;


import java.util.ArrayList;
import android.widget.ListView;
import android.util.Log;

class mostralistadinamica extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_lista_dinamica);

        ListView listview = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try{
            ArrayList<Pessoa> lista = bundle.getParcelableArrayList("contatos");
            PessoaAdapter adapter = new PessoaAdapter(mostralistadinamica.this, lista);
            listview.setAdapter(adapter);
        } catch (Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }

    }



}