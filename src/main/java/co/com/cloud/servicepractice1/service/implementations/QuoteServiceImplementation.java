package co.com.cloud.servicepractice1.service.implementations;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import co.com.cloud.servicepractice1.domain.Quote;
import co.com.cloud.servicepractice1.repository.QuoteRepository;
import co.com.cloud.servicepractice1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImplementation implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote findByNameAndCryptocurrency(String name, Cryptocurrency cryptocurrency) {
        return quoteRepository.findByNameAndCryptocurrency(name, cryptocurrency);
    }

    @Override
    public Quote findBySymbolAndCryptocurrency(String symbol, Cryptocurrency cryptocurrency) {
        return quoteRepository.findBySymbolAndCryptocurrency(symbol, cryptocurrency);
    }

    @Override
    public List<Quote> listAllQuotes() {
        return quoteRepository.findAll();
    }
}
