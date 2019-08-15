package org.munozy.microservices.demo.currencyexchangeservice.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@RequiredArgsConstructor(staticName = "of")
public class ExceptionReponse {
    @NonNull
    String message;
    @NonNull
    String description;
}
