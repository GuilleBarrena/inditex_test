package com.inditex.guillermobarrena.inditex;

import com.inditex.guillermobarrena.inditex.services.IPricesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndiTexApplicationTests {

    @Mock
    IPricesService service;

    @Test
    void contextLoads() {
    }

}
