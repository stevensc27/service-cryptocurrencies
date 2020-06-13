package co.com.cloud.servicepractice1.exceptions;

public class QuoteNameExceptionResponse {

    private String name;

    public QuoteNameExceptionResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
