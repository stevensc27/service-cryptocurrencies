package co.com.cloud.servicepractice1.repository;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency,Long> {

    public Cryptocurrency findByName(String name);
    public Cryptocurrency findBySymbol(String symbol);

}
