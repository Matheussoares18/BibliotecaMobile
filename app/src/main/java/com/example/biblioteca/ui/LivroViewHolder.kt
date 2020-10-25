package com.example.biblioteca.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.biblioteca.R

class LivroViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val tituloLivro: TextView = view.findViewById(R.id.texto_titulo)

    val anoLivro : TextView = view.findViewById(R.id.texto_ano)

    val isbn : TextView = view.findViewById(R.id.texto_isbn)

    val foto : ImageView = view.findViewById(R.id.imgFoto)

    override fun toString(): String {
        return super.toString() + " '" + tituloLivro.text + "'"
    }
}