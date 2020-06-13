package co.com.cloud.servicepractice1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CryptocurrencyNameException extends RuntimeException{

    public CryptocurrencyNameException(String message) {
        super(message);
    }
}
