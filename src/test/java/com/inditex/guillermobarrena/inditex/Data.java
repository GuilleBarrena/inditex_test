package com.inditex.guillermobarrena.inditex;

import com.inditex.guillermobarrena.inditex.controllers.dto.PriceDTO;
import com.inditex.guillermobarrena.inditex.domain.Price;
import lombok.Getter;

import java.text.ParseException;

import static com.inditex.guillermobarrena.inditex.DateUtils.convertDate;

@Getter
public class Data {
    public static final Price price_1;

    static {
        try {
            price_1 = new Price(
                    1,
                    1,
                    convertDate("2020-06-14-00.00.00"),
                    convertDate("2020-12-31-23.59.59"),
                    1,
                    35455,
                    0,
                    35.50,
                    "EUR"
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final PriceDTO priceDTO_1 = new PriceDTO(
            1,
            35455,
            "2020-06-14 00:00:00.0",
            "2020-12-31 23:59:59.0",
            35.50
    );
    public static final Price price_2;

    static {
        try {
            price_2 = new Price(
                    2,
                    1,
                    convertDate("2020-06-14-15.00.00"),
                    convertDate("2020-06-14-18.30.00"),
                    2,
                    35455,
                    0,
                    25.45,
                    "EUR"
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final PriceDTO priceDTO_2 = new PriceDTO(
            1,
            35455,
            "2020-06-14 15:00:00.0",
            "2020-06-14 18:30:00.0",
            25.45
    );
    public static final Price price_3;

    static {
        try {
            price_3 = new Price(
                    3,
                    1,
                    convertDate("2020-06-15-00.00.00"),
                    convertDate("2020-06-15-11.00.00"),
                    3,
                    35455,
                    0,
                    30.50,
                    "EUR"
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final PriceDTO priceDTO_3 = new PriceDTO(
            1,
            35455,
            "2020-06-15 00:00:00.0",
            "2020-06-15 11:00:00.0",
            30.50
    );
    public static final Price price_4;

    static {
        try {
            price_4 = new Price(
                    4,
                    1,
                    convertDate("2020-06-15-16.00.00"),
                    convertDate("2020-12-31-23.59.59"),
                    4,
                    35455,
                    0,
                    38.95,
                    "EUR"
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final PriceDTO priceDTO_4 = new PriceDTO(
            1,
            35455,
            "2020-06-15 16:00:00.0",
            "2020-12-31 23:59:59.0",
            38.95
    );
}


