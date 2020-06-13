package co.com.cloud.servicepractice1.exceptions;

public class QuotePriceExceptionResponse {

    private Double price;

    public QuotePriceExceptionResponse(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}