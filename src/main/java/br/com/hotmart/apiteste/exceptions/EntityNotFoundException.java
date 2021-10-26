package br.com.hotmart.apiteste.exceptions;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String why){
        super(why);
    }
}
