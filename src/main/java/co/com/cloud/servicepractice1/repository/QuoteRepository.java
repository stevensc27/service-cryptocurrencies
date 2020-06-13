package co.com.cloud.servicepractice1.repository;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import co.com.cloud.servicepractice1.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {

    public Quote findByNameAndCryptocurrency(String name, Cryptocurrency cryptocurrency);
    public Quote findBySymbolAndCryptocurrency(String symbol, Cryptocurrency cryptocurrency);
}
