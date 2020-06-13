package co.com.cloud.servicepractice1.controller;

import co.com.cloud.servicepractice1.domain.Cryptocurrency;
import co.com.cloud.servicepractice1.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @GetMapping
    public ResponseEntity<List<Cryptocurrency>> listAllCryptocurrencies(){
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.listAllCryptocurrencies();
        if (cryptocurrencies.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cryptocurrencies);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Cryptocurrency> findByName(@PathVariable("name") String name){
        Cryptocurrency cryptocurrency = cryptocurrencyService.findByName(name);
        if (cryptocurrency == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cryptocurrency);
    }

    @PostMapping
    public ResponseEntity<Cryptocurrency> createCryptocurrency(@RequestBody Cryptocurrency cryptocurrency){
        Cryptocurrency cryptocurrencyOld = cryptocurrencyService.findByName(cryptocurrency.getName());
        if (cryptocurrencyOld != null){
            return ResponseEntity.badRequest().build();
        }
        cryptocurrencyOld = cryptocurrencyService.findBySymbol(cryptocurrency.getSymbol());
        if (cryptocurrencyOld != null){
            return ResponseEntity.badRequest().build();
        }
        Cryptocurrency cryptocurrencyNew = cryptocurrencyService.createCryptocurrency(cryptocurrency);
        return ResponseEntity.status(HttpStatus.CREATED).body(cryptocurrencyNew);
    }
}
