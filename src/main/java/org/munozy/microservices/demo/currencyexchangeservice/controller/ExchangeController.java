package org.munozy.microservices.demo.currencyexchangeservice.controller;

import org.munozy.microservices.demo.currencyexchangeservice.dto.ExchangeDto;
import org.munozy.microservices.demo.currencyexchangeservice.service.ExchageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ExchangeController.PATH)
public class ExchangeController {

    static final String PATH = "/exchanges";

    @Autowired
    private ExchageService exchageService;

    @GetMapping(path = "/from/{from}/to/{to}")
    public ExchangeDto getExchange(@PathVariable String from, @PathVariable String to) {
       return exchageService.getExchange(from, to);
    }
}
