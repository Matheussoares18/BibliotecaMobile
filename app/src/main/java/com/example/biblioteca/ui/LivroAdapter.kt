package com.example.biblioteca.ui

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.biblioteca.R
import com.example.biblioteca.model.Livro
import com.google.firebase.storage.FirebaseStorage


class LivroAdapter(
        private val activity : FragmentActivity,
        private val viewModel : LivroViewModel,
        private val Livros: List<Livro>)
    : RecyclerView.Adapter<LivroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_livro, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = Livros[position]
        holder.tituloLivro.text = livro.titulo
        holder.anoLivro.text = livro.ano
        holder.isbn.text = livro.ISBN

        val storage = FirebaseStorage.getInstance()
        val storageReference = storage.getReference(livro.foto)
        storageReference.downloadUrl.addOnSuccessListener {
            imageUrl ->
            Glide.with(activity)
                .load(imageUrl)
                .into(holder.foto)
        }

        storageReference.downloadUrl.addOnFailureListener{
            Glide.with(activity)
                .load(R.drawable.estante)
                .into(holder.foto)
        }

        holder.itemView.setOnClickListener{
            view ->
            viewModel.livro.value = livro

            view.findNavController().navigate(R.id.action_lista_para_detalhes_livros)
        }

        holder.itemView.setOnLongClickListener{
            view ->
            view?.let {
                AlertDialog.Builder(activity)
                    .setTitle("Atenção")
                    .setMessage("Deseja escluir o livro")
                    .setPositiveButton("Sim"){
                        dialog, which ->
                        viewModel.repository.excluirLivro(livro.docId)
                    }
                    .setNegativeButton("Não",null)
                    .show()
            }
            true
        }
    }

    override fun getItemCount(): Int = Livros.size


}