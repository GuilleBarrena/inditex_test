package com.inditex.guillermobarrena.inditex.controllers.converters.impl;

import com.inditex.guillermobarrena.inditex.controllers.converters.AbstractConverter;
import com.inditex.guillermobarrena.inditex.domain.Price;
import com.inditex.guillermobarrena.inditex.controllers.dto.PriceDTO;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.inditex.guillermobarrena.inditex.DateUtils.convertDate;

@Component
public class PriceConverter extends AbstractConverter<PriceDTO, Price> {
    final String OLD_FORMAT = "yyyy-MM-dd";
    final String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    @Override
    public Price convertDTOToDomain(PriceDTO bean) throws ParseException {

        if (bean == null) return null;
        return new Price(
                null,
                bean.getBrandId(),
                convertDate(bean.getStartDate()),
                convertDate(bean.getEndDate()),
                null,
                bean.getProductId(),
                null,
                bean.getPrice(),
                null
        );
    }

    @Override
    public PriceDTO convertDomainToDTO(Price domain) {
        if (domain == null) return null;
        return new PriceDTO(
                domain.getBrandId(),
                domain.getProductId(),
                domain.getStartDate().toString(),
                domain.getEndDate().toString(),
                domain.getPrice()
        );
    }
}
