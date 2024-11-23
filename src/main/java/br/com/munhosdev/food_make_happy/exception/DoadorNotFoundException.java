package br.com.munhosdev.food_make_happy.exception;

import br.com.munhosdev.food_make_happy.exception.handlers.CustomErrorDetail;
import br.com.munhosdev.food_make_happy.exception.handlers.FoodMakeHappyException;
import org.springframework.http.HttpStatus;

public class DoadorNotFoundException extends FoodMakeHappyException {

    private final String description;

    public DoadorNotFoundException(String description) {
        this.description = description;
    }

    @Override
    public CustomErrorDetail toCustomErrorDetail() {
        return toCustomErrorDetail(HttpStatus.NOT_FOUND,
                "Doador não encontrado.",description);
    }
}
