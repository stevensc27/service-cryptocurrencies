package co.com.cloud.servicepractice1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cryptocurrencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cryptocurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name's cryptocurrency can't be empty")
    private String name;
    @NotEmpty(message = "symbol's cryptocurrency can't be empty")
    private String symbol;
    private Integer rank = 0;
}
