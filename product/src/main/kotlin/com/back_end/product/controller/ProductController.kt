package com.back_end.product.controller

import com.back_end.product.domain.Product
import com.back_end.product.service.ProductService
import org.springframework.web.bind.annotation.*

//Es un enrutador para la logica de negocios, para ayudarnos
//a reciclar codigo, se implenta la clase abstracta


@RestController
@RequestMapping("/api/v1/product")
class ProductController(productService: ProductService):BasicController<Product, String>(productService)

