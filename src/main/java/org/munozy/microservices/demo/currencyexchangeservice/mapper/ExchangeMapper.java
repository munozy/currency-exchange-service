package org.munozy.microservices.demo.currencyexchangeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.munozy.microservices.demo.currencyexchangeservice.domain.Exchange;
import org.munozy.microservices.demo.currencyexchangeservice.dto.ExchangeDto;

@Mapper(componentModel = "spring")
public interface ExchangeMapper {

    Exchange toExchange(ExchangeDto exchangeDto);

    ExchangeDto toExchangeDto(Exchange exchange);
}
