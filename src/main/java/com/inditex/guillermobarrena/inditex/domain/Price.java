package com.inditex.guillermobarrena.inditex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Time;
import java.sql.Timestamp;

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
    private final Double price;
    private final String currency;
}
