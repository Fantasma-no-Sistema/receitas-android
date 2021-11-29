package com.fantasma.receitas.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fantasma.receitas.R
import com.fantasma.receitas.domain.Receita
import com.squareup.picasso.Picasso

class ReceitasAdapter(val list: ArrayList<Receita>) :
    RecyclerView.Adapter<ReceitasAdapter.ReceitaViewHolder>() {
    class ReceitaViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {

        val textViewTituloReceita = itemView.findViewById<TextView>(R.id.textViewTituloReceita)
        val imageViewFotoReceita = itemView.findViewById<ImageView>(R.id.imageViewFotoReceita)
        val imageButtonFavoritar = itemView.findViewById<ImageButton>(R.id.imageButtonFavoritar)
        val imageButtonCompartilhar = itemView.findViewById<ImageButton>(R.id.imageButtonCompartilhar)

        fun bindData(receita: Receita) {
            textViewTituloReceita.text = receita.titulo
            Picasso.get().load(receita.imgUri).into(imageViewFotoReceita)
            imageButtonFavoritar.setBackgroundColor(context.resources.getColor(R.color.black))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_receita, parent, false)
        return ReceitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}