package com.inditex.guillermobarrena.inditex.repositories.facades.impl;

import com.inditex.guillermobarrena.inditex.Data;
import com.inditex.guillermobarrena.inditex.DateUtils;
import com.inditex.guillermobarrena.inditex.domain.Price;
import com.inditex.guillermobarrena.inditex.repositories.entities.PricesEntity;
import com.inditex.guillermobarrena.inditex.repositories.facades.IPriceRepositoryFacade;
import com.inditex.guillermobarrena.inditex.repositories.repositories.IPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PriceRepositoryFacadeImplTest {

    @Autowired
    PriceRepositoryFacadeImpl facade;

    @Test
    void findAll(
    ) {
        List<Price> list = facade.findAll();
        assertEquals(list.isEmpty(), false);
    }

    @Test
    void findFirst() throws ParseException {
        Timestamp timestamp = DateUtils.convertDate("2020-06-14-10.00.00.00");
        Price price = facade.findFirst(1, 35455, timestamp, timestamp);
        assertEquals(price.getPrice(), Data.price_1.getPrice());
    }
}