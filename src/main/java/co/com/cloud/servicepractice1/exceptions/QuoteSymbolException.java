package co.com.cloud.servicepractice1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuoteSymbolException extends RuntimeException{

    public QuoteSymbolException(String message) {
        super(message);
    }
}
