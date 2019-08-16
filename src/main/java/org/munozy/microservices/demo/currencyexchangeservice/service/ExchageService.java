package org.munozy.microservices.demo.currencyexchangeservice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.munozy.microservices.demo.currencyexchangeservice.domain.Exchange;
import org.munozy.microservices.demo.currencyexchangeservice.dto.ExchangeDto;
import org.munozy.microservices.demo.currencyexchangeservice.exception.ResourceNotFoundException;
import org.munozy.microservices.demo.currencyexchangeservice.mapper.ExchangeMapper;
import org.munozy.microservices.demo.currencyexchangeservice.repository.ExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExchageService {

    static final Logger LOGGER = LoggerFactory.getLogger(ExchageService.class);
   final ExchangeRepository exchangeRepository;

   final ExchangeMapper exchangeMapper;

   final  Environment environment;

    public ExchangeDto getExchange(String from, String to) {
        Exchange exchange = exchangeRepository.findByFromAndTo( from, to)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("It isn't possible to retrieve exchange (from %s" +
                                " to %s because it doesn't exist.", from, to)));

        ExchangeDto exchangeDto = exchangeMapper.toExchangeDto(exchange);
        exchangeDto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        LOGGER.info("{}", exchangeDto);

        return exchangeDto;
    }
}
