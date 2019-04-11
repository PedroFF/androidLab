package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PalavraAdapter extends RecyclerView.Adapter<PalavraAdapter.ViewHolder> {

    private final List<String> items;
    private OnPalavraClickListener listener;

    public interface OnPalavraClickListener{
        void onPalavraClick(View palavraView, int position);
    }

    public PalavraAdapter(List<String> palavras) {
        this.items = palavras;
    }

    public void setOnPalavraClickListener(OnPalavraClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public PalavraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View linha = inflater.inflate(R.layout.palavra_layout, parent, false);
        ViewHolder vh = new ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PalavraAdapter.ViewHolder viewHolder, int i) {
        String palavra = this.items.get(i);
        viewHolder.txtPalavra.setText(palavra);
        viewHolder.txtTamanho.setText(Integer.toString(palavra.length()));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtPalavra;
        TextView txtTamanho;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPalavra = itemView.findViewById(R.id.textView);
            txtTamanho = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        int position =  getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onPalavraClick(view, position);
                        }
                    }
                }
            });

        }
    }

}

