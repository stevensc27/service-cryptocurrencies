package co.com.cloud.servicepractice1.service;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import co.com.cloud.servicepractice1.domain.Quote;

import java.util.List;

public interface QuoteService {

    public Quote createQuote(Quote quote);
    public Quote findByNameAndCryptocurrency(String name, Cryptocurrency cryptocurrency);
    public Quote findBySymbolAndCryptocurrency(String symbol, Cryptocurrency cryptocurrency);
    public List<Quote> listAllQuotes();
}
