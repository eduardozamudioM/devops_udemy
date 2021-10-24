package com.back_end.product.domain

data class Product(val name: String, var price: Double? = 55.5) {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if(other === this) return true
//        if(this.javaClass != other::class.java) return false
        other as  Product
        return this.name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}