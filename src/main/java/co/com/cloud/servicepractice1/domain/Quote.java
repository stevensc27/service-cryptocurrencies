package co.com.cloud.servicepractice1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name's quote can't be empty")
    private String name;
    @NotEmpty(message = "symbol's quote can't be empty")
    private String symbol;
    @Positive(message = "price's quote must be positive")
    private Double price;
    @Column(name = "last_update")
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cryptocurrency_id")
    private Cryptocurrency cryptocurrency;
}