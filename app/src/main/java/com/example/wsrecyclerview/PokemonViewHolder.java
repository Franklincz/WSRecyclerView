package com.example.wsrecyclerview;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private ImageView imgFotoPokemon;
    private TextView lblNombrePokemon;
    private PokemonRecyclerAdapter pokemonRecyclerAdapter;

    public PokemonViewHolder(View view){
        super(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);

        imgFotoPokemon=(ImageView)view.findViewById(R.id.imgPokemon_item);
        lblNombrePokemon=(TextView)view.findViewById(R.id.lblNombrePokemon_item);
    }
    public ImageView getImgFotoPokemon(){
        return imgFotoPokemon;

    }
    public TextView getLblNombrePokemon(){
        return lblNombrePokemon;

    }
    @Override
    public void  onClick(View view){
        pokemonRecyclerAdapter.clickListener.onItemLongClick(getAdapterPosition(), view);

    }


    @Override
    public boolean onLongClick(View view) {
        pokemonRecyclerAdapter.clickListener.onItemLongClick(getAdapterPosition(), view);

        return false;
    }
}
