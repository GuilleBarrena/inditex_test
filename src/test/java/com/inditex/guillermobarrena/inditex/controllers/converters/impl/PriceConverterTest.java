package com.inditex.guillermobarrena.inditex.controllers.converters.impl;

import com.inditex.guillermobarrena.inditex.Data;
import com.inditex.guillermobarrena.inditex.controllers.converters.AbstractConverter;
import com.inditex.guillermobarrena.inditex.controllers.dto.PriceDTO;
import com.inditex.guillermobarrena.inditex.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class PriceConverterTest {
    AbstractConverter<PriceDTO, Price> converter;

    @BeforeEach
    void setUp() {
        converter = new PriceConverter();
    }

    @Test
    void convertDTOToDomain() throws ParseException {
        Price price = converter.convertDTOToDomain(
                new PriceDTO(
                        1,
                        1000,
                        "2020-10-01-00.00.00",
                        "2020-10-02-00.00.00",
                        new BigDecimal(365.90)
                )
        );

        assertEquals(price.getId(), null);
        assertEquals(price.getBrandId(), 1);
        assertEquals(price.getProductId(), 1000);
        assertEquals(price.getStartDate().toString(), "2020-10-01 00:00:00.0");
        assertEquals(price.getEndDate().toString(), "2020-10-02 00:00:00.0");
        assertEquals(price.getPriceList(), null);
        assertEquals(price.getPriority(), null);
        assertEquals(price.getPrice(), new BigDecimal(365.90));
        assertEquals(price.getCurrency(), null);
    }

    @Test
    void convertDomainToDTO() {
        PriceDTO priceDto = converter.convertDomainToDTO(Data.price_3);
        assertEquals(priceDto.getBrandId(), Data.priceDTO_3.getBrandId());
        assertEquals(priceDto.getProductId(), Data.priceDTO_3.getProductId());
        assertEquals(priceDto.getStartDate(), Data.priceDTO_3.getStartDate());
        assertEquals(priceDto.getEndDate(), Data.priceDTO_3.getEndDate());
        assertEquals(priceDto.getPrice(), Data.priceDTO_3.getPrice());
    }
}