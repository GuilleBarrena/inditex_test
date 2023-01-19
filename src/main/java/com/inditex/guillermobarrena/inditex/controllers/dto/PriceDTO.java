package com.inditex.guillermobarrena.inditex.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class PriceDTO {
    private final Integer brandId;
    private final Integer productId;
    private final String startDate;
    private final String endDate;
    private final Double price;
}
