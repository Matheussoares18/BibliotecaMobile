package com.example.biblioteca.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.biblioteca.R
import com.example.biblioteca.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListaLivroFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.lista_de_livros, container, false)
        var recycler = view.findViewById<RecyclerView>(R.id.list)
        var viewModel = ViewModelProvider(requireActivity()).get(LivroViewModel::class.java)

        viewModel.listaDeLivro.observe(requireActivity()) { livros ->
            with(recycler) {
                adapter = LivroAdapter(requireActivity(), viewModel, livros)
            }

        }

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            viewModel.livro.value = Livro()
            findNavController().navigate(R.id.action_lista_para_detalhes_livros)
        }
        return view
    }


}