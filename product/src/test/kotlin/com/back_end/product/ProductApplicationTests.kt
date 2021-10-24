package com.back_end.product

import com.back_end.product.domain.Product
import com.back_end.product.service.ProductService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.Test;
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest
class ProductApplicationTests {


	@Autowired
	private  lateinit var  webApplicationContext: WebApplicationContext

	 private val mockmvc: MockMvc by lazy {
		 MockMvcBuilders.webAppContextSetup(webApplicationContext)
			 .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print()).build()
	 }

	 @Autowired
	 private  lateinit var mapper: ObjectMapper

	 @Autowired
	 private lateinit var productService: ProductService



	 @Test
	 fun findAll(){
		 val productdFromService = productService.findAll()


		 val products: List<Product> = mockmvc.perform(MockMvcRequestBuilders.get("/api/v1/product"))
			 .andExpect(status().isOk).bodyto(mapper)

		 assertThat(productdFromService, Matchers.`is`(Matchers.equalTo(products)))

	 }

}
