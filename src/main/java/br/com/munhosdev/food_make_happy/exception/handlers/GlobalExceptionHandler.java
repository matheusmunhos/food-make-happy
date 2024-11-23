package br.com.munhosdev.food_make_happy.exception.handlers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FoodMakeHappyException.class)
    public ResponseEntity<CustomErrorDetail> handlerFoodMakeHappy(FoodMakeHappyException ex){
        return new ResponseEntity<>(ex.toCustomErrorDetail(), HttpStatusCode.valueOf(ex.toCustomErrorDetail().status()));
    }
}
