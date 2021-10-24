package com.back_end.product.service

interface BasicCrud<T,ID> {

    fun findAll(): List <T>
    fun findbyId(id: ID): T?
    fun save(t:T) : Boolean
    fun update(t:T): Boolean
    fun deletedById(id:ID): Boolean

}