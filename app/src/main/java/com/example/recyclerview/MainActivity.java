package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recyclerView);
        PalavraAdapter pAdapter = new PalavraAdapter(this.palavras);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pAdapter.setOnPalavraClickListener(new PalavraAdapter.OnPalavraClickListener() {
            @Override
            public void onPalavraClick(View palavraView, int position) {
                Toast.makeText(MainActivity.this, palavras.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<String> palavras = new ArrayList<String>(){{
        add("Um");
        add("Dois");
        add("Três");
        add("Quatro");
    }};

}
