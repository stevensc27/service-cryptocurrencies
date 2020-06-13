package co.com.cloud.servicepractice1.exceptions;

public class CryptocurrencySymbolExceptionResponse {

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CryptocurrencySymbolExceptionResponse(String symbol) {
        this.symbol = symbol;
    }
}
