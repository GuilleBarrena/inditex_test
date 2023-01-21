package com.inditex.guillermobarrena.inditex.controllers.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.guillermobarrena.inditex.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesControllerTest {
    @Autowired
    private WebTestClient client;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void getAll() throws Exception {
        client.get().uri("/api/v1/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json(mapper.writeValueAsString(
                        List.of(
                                Data.priceDTO_1,
                                Data.priceDTO_2,
                                Data.priceDTO_3,
                                Data.priceDTO_4
                        )));
    }

    @Test
    void testPrice_1() throws JsonProcessingException {
        client
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/v1/prices")
                                .queryParam("brandId", 1)
                                .queryParam("productId", 35455)
                                .queryParam("startDate", "2020-06-14-10.00.00")
                                .queryParam("endDate", "2020-06-14-10.00.00")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json(mapper.writeValueAsString(Data.priceDTO_1));
    }

    @Test
    void testPrice_2() throws JsonProcessingException {
        client
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/v1/prices")
                                .queryParam("brandId", 1)
                                .queryParam("productId", 35455)
                                .queryParam("startDate", "2020-06-14-16.00.00")
                                .queryParam("endDate", "2020-06-14-16.00.00")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json(mapper.writeValueAsString(Data.priceDTO_2));
    }

    @Test
    void testPrice_3() throws JsonProcessingException {
        client
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/v1/prices")
                                .queryParam("brandId", 1)
                                .queryParam("productId", 35455)
                                .queryParam("startDate", "2020-06-14-21.00.00")
                                .queryParam("endDate", "2020-06-14-21.00.00")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json(mapper.writeValueAsString(Data.priceDTO_1));
    }

    @Test
    void testPrice_4() throws JsonProcessingException {
        client
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/v1/prices")
                                .queryParam("brandId", "1")
                                .queryParam("startDate", "2020-06-15-10.00.00")
                                .queryParam("endDate", "2020-06-15-10.00.00")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json(mapper.writeValueAsString(Data.priceDTO_3));
    }

    @Test
    void testPrice_5() throws JsonProcessingException {
        client
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/v1/prices")
                                .queryParam("brandId", "1")
                                .queryParam("startDate", "2020-06-15-21.00.00")
                                .queryParam("endDate", "2020-06-15-21.00.00")
                                .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json(mapper.writeValueAsString(Data.priceDTO_4));
    }
}