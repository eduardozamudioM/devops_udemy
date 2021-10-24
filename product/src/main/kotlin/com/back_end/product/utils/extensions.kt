package com.back_end.product.utils


//Podemos extender las funcionalidaes de cualquier clase
//Es una funciòn de kotlin

fun <E> MutableSet<E>.update(element: E): Boolean{
    return this.remove(element) && this.add(element)
}