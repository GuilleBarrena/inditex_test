package com.inditex.guillermobarrena.inditex.controllers.api.v1;

import com.inditex.guillermobarrena.inditex.controllers.converters.AbstractConverter;
import com.inditex.guillermobarrena.inditex.domain.Price;
import com.inditex.guillermobarrena.inditex.services.IPricesService;
import com.inditex.guillermobarrena.inditex.controllers.dto.PriceDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController("pricesController")
@RequestMapping("/api/v1/")
public class PricesController {

    private final AbstractConverter<PriceDTO, Price> converter;

    private final IPricesService service;

    public PricesController(AbstractConverter<PriceDTO, Price> converter, IPricesService service) {
        this.converter = converter;
        this.service = service;
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PriceDTO>> getAll() {
        List<PriceDTO> prices = service.getAll()
                .stream()
                .map(converter::convertDomainToDTO)
                .toList();
        return new ResponseEntity<>(prices, new HttpHeaders(), OK);
    }

    @GetMapping(value = "prices", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) Integer productId
    ) throws ParseException {
        Price price = service.findOne(
                converter.convertDTOToDomain(new PriceDTO(
                        brandId,
                        productId,
                        startDate,
                        endDate,
                        null
                )));
        return new ResponseEntity<>(converter.convertDomainToDTO(price), new HttpHeaders(), OK);
    }
}
