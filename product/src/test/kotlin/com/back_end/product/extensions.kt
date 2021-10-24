package com.back_end.product

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.test.web.servlet.ResultActions

inline fun<reified T> ResultActions.bodyto(mapper: ObjectMapper = jacksonObjectMapper()) : T{
    return mapper.readValue(this.andReturn().response.contentAsByteArray)
}