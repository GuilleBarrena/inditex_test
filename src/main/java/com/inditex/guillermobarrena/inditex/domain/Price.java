package com.inditex.guillermobarrena.inditex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Currency;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Price {
    private final Integer id;
    private final Integer brandId;
    private final Timestamp startDate;
    private final Timestamp endDate;
    private final Integer priceList;
    private final Integer productId;
    private final Integer priority;
    private final BigDecimal price;
    private final Currency currency;
}
