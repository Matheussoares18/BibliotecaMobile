package com.example.biblioteca.model


data class Livro (

    var docId :String,
    var titulo:String,
    var ISBN :String,
    var ano :String,
    var foto :String
)
{
    constructor() : this(String(),String(),String(),String(), String())
}