package com.example.wsrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PokemonRecyclerAdapter extends RecyclerView.Adapter<PokemonViewHolder>{
    public static ClickListener clickListener;
    private List <Pokemon> pokemonList= new ArrayList<>();
    public PokemonRecyclerAdapter(List<Pokemon> pokemonList){
        this.pokemonList=pokemonList;
    }
    public PokemonRecyclerAdapter(){
        this.pokemonList = new ArrayList<>();
    }
    public void setAddListPokemons(List<Pokemon> pokemonLista){
         pokemonList.addAll(pokemonLista);
         notifyDataSetChanged();
    }
    @Override
    public int getItemCount(){
        return pokemonList.size();
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.item_pokemon, parent, false);

        return new PokemonViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {


        Pokemon pokemon=pokemonList.get(position);
        holder.getLblNombrePokemon().setText(pokemon.getNombre());
        String urlFoto="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" +pokemon.getId()+".png";
        Glide.with(holder.itemView.getContext())
                .load(urlFoto)
                .into(holder.getImgFotoPokemon());




    }

    public interface ClickListener{
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);

    }
    public void setOnItemClickListener(ClickListener clickListener){
          PokemonRecyclerAdapter.clickListener=clickListener;
    }
}
