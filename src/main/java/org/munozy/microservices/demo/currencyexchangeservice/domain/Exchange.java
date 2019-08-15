package org.munozy.microservices.demo.currencyexchangeservice.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "exchange",
        schema = "currency_exchange_service",
        uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = { "source" , "target"},
                    name = "constraint_unique_exchange_source_target"
            )
        }
)
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_exchange_generator")
    @GenericGenerator(
            name = "sequence_exchange_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "currency_exchange_service.seq_exchange"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    long id;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(name= "source", length = 3, nullable = false, columnDefinition = "char")
    String from;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(name= "target", length = 3, nullable = false, columnDefinition = "char")
    String to;

    @NotNull
    @Column(nullable = false)
    BigDecimal conversion;
}
