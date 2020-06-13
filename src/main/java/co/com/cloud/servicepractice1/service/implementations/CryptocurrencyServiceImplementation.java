package co.com.cloud.servicepractice1.service.implementations;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import co.com.cloud.servicepractice1.domain.Quote;
import co.com.cloud.servicepractice1.exceptions.CryptocurrencyNameException;
import co.com.cloud.servicepractice1.repository.CryptocurrencyRepository;
import co.com.cloud.servicepractice1.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptocurrencyServiceImplementation implements CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Override
    public List<Cryptocurrency> listAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    @Override
    public Cryptocurrency findByName(String name) {
        return cryptocurrencyRepository.findByName(name);
    }

    @Override
    public Cryptocurrency findBySymbol(String symbol) {
        return cryptocurrencyRepository.findBySymbol(symbol);
    }

    @Override
    public Cryptocurrency createCryptocurrency(Cryptocurrency cryptocurrency) {
        try {
            return cryptocurrencyRepository.save(cryptocurrency);
        } catch (Exception e){
            throw new CryptocurrencyNameException("Name can't be empty");
        }
    }

    @Override
    public Cryptocurrency updateCryptocurrency(Cryptocurrency cryptocurrency) {
        if (getCryptocurrency(cryptocurrency.getId()) == null){
            return null;
        }
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    @Override
    public Cryptocurrency getCryptocurrency(Long id) {
        return cryptocurrencyRepository.findById(id).orElse(null);
    }


}
