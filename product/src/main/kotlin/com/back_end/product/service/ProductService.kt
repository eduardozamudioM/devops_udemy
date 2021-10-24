package com.back_end.product.service

import com.back_end.product.domain.Product
import com.back_end.product.utils.update
import org.springframework.boot.context.properties.bind.Bindable.setOf
import org.springframework.stereotype.Service

@Service
class ProductService : BasicCrud<Product, String> {

    private val products: MutableSet<Product> =
        mutableSetOf(Product("apple", 22.0), Product("banana", 66.0))

    override fun findAll(): List<Product> = products.toList()

    override fun findbyId(id: String): Product? =
        this.products.find { it.name == id }

    override fun save(t: Product): Boolean = products.add(t)

    override fun update(t: Product): Boolean = this.products.update(t)

    override fun deletedById(id: String): Boolean =
        products.remove(findbyId(id))

}