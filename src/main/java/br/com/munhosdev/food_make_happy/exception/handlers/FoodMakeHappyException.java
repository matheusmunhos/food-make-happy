package br.com.munhosdev.food_make_happy.exception.handlers;

import org.springframework.http.HttpStatus;

public abstract class FoodMakeHappyException extends RuntimeException {

    public CustomErrorDetail toCustomErrorDetail(HttpStatus status, String message, String description){
        return new CustomErrorDetail(status.value(),status.name(),message,description);

    }

    public abstract CustomErrorDetail toCustomErrorDetail();
}
