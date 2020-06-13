package co.com.cloud.servicepractice1.controller;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import co.com.cloud.servicepractice1.domain.Quote;
import co.com.cloud.servicepractice1.service.CryptocurrencyService;
import co.com.cloud.servicepractice1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote){

        // validations if exists same name or same symbol with cryptocurrency in quotes
        Quote quoteOld = quoteService.findByNameAndCryptocurrency(quote.getName(), quote.getCryptocurrency());
        if (quoteOld != null){
            return ResponseEntity.badRequest().build();
        }
        quoteOld = quoteService.findBySymbolAndCryptocurrency(quote.getSymbol(), quote.getCryptocurrency());
        if (quoteOld != null){
            return ResponseEntity.badRequest().build();
        }
        if (!quote.getSymbol().equals("USD") && !quote.getSymbol().equals("EUR") && !quote.getSymbol().equals("GBP")){
            return ResponseEntity.badRequest().build();
        }

        // save new quote
        Quote quoteNew = quoteService.createQuote(quote);

        // save all rank zeros to proceed to evaluate the max
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.listAllCryptocurrencies();
        for (Cryptocurrency c : cryptocurrencies){
            c.setRank(0);
            cryptocurrencyService.updateCryptocurrency(c);
        }

        // evaluate the max price by converting them to dollars
        List<Quote> quotes = quoteService.listAllQuotes();
        Quote quoteMax = Collections.max(quotes, Comparator.comparing(q -> calculateCurrencyValue(q.getSymbol() , q.getPrice())));

        // update cryptocurrency with max value
        Cryptocurrency cryptocurrency = cryptocurrencyService.getCryptocurrency(quoteMax.getCryptocurrency().getId());
        cryptocurrency.setRank(1);
        cryptocurrencyService.updateCryptocurrency(cryptocurrency);

        return ResponseEntity.status(HttpStatus.CREATED).body(quoteNew);
    }

    // return value currency in dollars
    private Double calculateCurrencyValue(String symbol, Double value){
        if (symbol.equals("USD")){
            return value;
        } else if (symbol.equals("EUR")){
            return value / 0.80;
        } else if (symbol.equals("GBP")){
            return value / 0.66;
        }
        return 0D;
    }
}
