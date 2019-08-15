package org.munozy.microservices.demo.currencyexchangeservice.repository;

import org.munozy.microservices.demo.currencyexchangeservice.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface  ExchangeRepository extends JpaRepository<Exchange, Long> {

    Optional<Exchange> findByFromAndTo(String from, String to);
}
