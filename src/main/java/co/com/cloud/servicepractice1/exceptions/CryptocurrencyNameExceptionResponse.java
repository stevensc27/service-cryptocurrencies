package co.com.cloud.servicepractice1.exceptions;

public class CryptocurrencyNameExceptionResponse {

    private String name;

    public CryptocurrencyNameExceptionResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
