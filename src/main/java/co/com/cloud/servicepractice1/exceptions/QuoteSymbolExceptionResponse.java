package co.com.cloud.servicepractice1.exceptions;

public class QuoteSymbolExceptionResponse {

    private String symbol;

    public QuoteSymbolExceptionResponse(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
