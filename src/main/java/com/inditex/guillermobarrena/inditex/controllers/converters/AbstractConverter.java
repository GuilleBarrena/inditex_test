package com.inditex.guillermobarrena.inditex.controllers.converters;

import java.text.ParseException;

public abstract class AbstractConverter<DTO, DOMAIN> {
    public abstract DOMAIN convertDTOToDomain(DTO bean) throws ParseException;
    public abstract DTO convertDomainToDTO(DOMAIN domain);
}
