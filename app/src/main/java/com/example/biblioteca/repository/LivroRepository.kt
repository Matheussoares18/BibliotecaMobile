package com.example.biblioteca.repository

import androidx.lifecycle.MutableLiveData
import com.example.biblioteca.model.Livro
import com.google.firebase.firestore.FirebaseFirestore

class LivroRepository {

    var listaDeLivros = MutableLiveData<MutableList<Livro>>()
    private val db = FirebaseFirestore.getInstance()

    init{
    db.collection("livros")
        .get()
        .addOnCompleteListener{
            docs ->
            if(docs.isSuccessful){
                var livros = mutableListOf<Livro>()
                docs.result?.forEach {
                    doc -> val livro = doc.toObject(Livro::class.java)
                    if(livro != null ){
                        livro.docId = doc.id
                        livros.add(livro)
                    }
                }

                listaDeLivros.value = livros
            }else{
                listaDeLivros.value = mutableListOf()
            }
        }
        db.collection("livros")
            .addSnapshotListener{
                snapshot, _ ->
                if(snapshot != null){
                    var livros = mutableListOf<Livro>()
                    snapshot.documents?.forEach {
                            doc -> val livro = doc.toObject(Livro::class.java)
                        if(livro != null ){
                            livro.docId = doc.id
                            livros.add(livro)
                        }
                    }

                }

            }
    }

    fun salvarLivros(livro: Livro)  {
        if(livro.docId.isBlank()){
            var doc = db.collection("livros").document()
            livro.docId = doc.id
            doc.set(livro)
        }else{
            db.collection("livros")
                .document(livro.docId)
                .set(livro)
        }
    }

    fun excluirLivro(docId:String)  {
        db.collection("livros")
            .document(docId)
            .delete()

    }

}