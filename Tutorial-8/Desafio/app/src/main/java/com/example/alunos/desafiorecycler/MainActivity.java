package com.example.alunos.desafiorecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alunos.desafiorecycler.adapter.LivroAdapter;
import com.example.alunos.desafiorecycler.model.Livro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<Livro> listaLivros;
    RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        rview = findViewById(R.id.recyclerView);
        listaLivros = new ArrayList<>();
        listaLivros.add(new Livro ("Incidente em antares", "Algum ai",
                "Tretas em familia"));
        listaLivros.add(new Livro ("Vidas secas", "Algum ai",
                "Nordestinos e a falta de agua"));
        listaLivros.add(new Livro ("Algum ai", "Algum ai",
                "Algum ai"));

        
    }

	public void adicionarLivro(){
		EditText titulo = findViewById(R.id.txtTitulo);
		EditText autor = findViewById(R.id.txtAutor);
		EditText desc = findViewById(R.id.txtDesc);
		String livroTitulo = titulo.getText().toString();
		String livroAutor = autor.getText().toString();
		String livroDesc = desc.getText().toString();
		listaLivros.add(new Livro (livroTitulo, livroAutor,
                livroDesc));
	}

	public void mostrarLista(){
		setContentView(R.layout.activity_main);
        rview = findViewById(R.id.recyclerView);
		rview.setAdapter(new LivroAdapter(listaLivros, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rview.setLayoutManager(layout);
		
	}

	
}

