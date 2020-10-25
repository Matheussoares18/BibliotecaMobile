package com.example.biblioteca.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.biblioteca.model.Livro
import com.example.biblioteca.repository.LivroRepository

class LivroViewModel(app:Application) : AndroidViewModel(app) {

    var livro = MutableLiveData<Livro>()
    //val livroDao = Banco.get(app).livroDao()
    var repository = LivroRepository()
    //var listaDeLivro = livroDao.listaTodos()
    var listaDeLivro = repository.listaDeLivros

}