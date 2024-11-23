package br.com.munhosdev.food_make_happy.exception;

import br.com.munhosdev.food_make_happy.exception.handlers.CustomErrorDetail;
import br.com.munhosdev.food_make_happy.exception.handlers.FoodMakeHappyException;
import org.springframework.http.HttpStatus;

public class ReceptorNotFoundException extends FoodMakeHappyException {

    private final String description;

    public ReceptorNotFoundException(String description) {
        this.description = description;
    }

    @Override
    public CustomErrorDetail toCustomErrorDetail() {
        return toCustomErrorDetail(HttpStatus.NOT_FOUND,
                "Receptor não encontrado.",description);
    }
}
