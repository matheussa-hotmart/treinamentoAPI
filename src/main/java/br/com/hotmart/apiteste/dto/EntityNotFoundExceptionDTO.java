package br.com.hotmart.apiteste.dto;

public class EntityNotFoundExceptionDTO {
    private String message;
    private int httpStatus;

    public EntityNotFoundExceptionDTO(String message, int httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
