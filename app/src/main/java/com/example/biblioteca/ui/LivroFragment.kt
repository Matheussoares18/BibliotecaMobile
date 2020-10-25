package com.example.biblioteca.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.biblioteca.R
import com.example.biblioteca.model.Livro
import kotlinx.android.synthetic.main.livro_fragment.*

class LivroFragment : Fragment() {


    private lateinit var viewModel: LivroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.livro_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(LivroViewModel::class.java)

        viewModel.livro.observe(viewLifecycleOwner) {
                livro ->
            txtTitulo.setText(livro.titulo)
            txtISBN.setText(livro.ISBN)
            txtAno.setText(livro.ano)
            txtFoto.setText(livro.foto)

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener{

                var livro = Livro(
                    docId = livro.docId,
                    titulo = txtTitulo.text.toString(),
                    ISBN  = txtISBN.text.toString(),
                    ano = txtAno.text.toString(),
                    foto = txtFoto.toString()
                )
                val titulo = txtTitulo.text.toString()
                val  ISBN  = txtISBN.text.toString()
                val ano = txtAno.text.toString()

                viewModel.repository.salvarLivros(livro)
                findNavController().navigateUp()
            }

        }

        return view
    }


}