package co.com.cloud.servicepractice1.service;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;

import java.util.List;

public interface CryptocurrencyService {

    public List<Cryptocurrency> listAllCryptocurrencies();
    public Cryptocurrency findByName(String name);
    public Cryptocurrency findBySymbol(String symbol);
    public Cryptocurrency createCryptocurrency(Cryptocurrency cryptocurrency);
    public Cryptocurrency updateCryptocurrency(Cryptocurrency cryptocurrency);
    public Cryptocurrency getCryptocurrency(Long id);
}
