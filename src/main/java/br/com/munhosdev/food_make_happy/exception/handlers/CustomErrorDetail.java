package br.com.munhosdev.food_make_happy.exception.handlers;

public record CustomErrorDetail(
        int status,
        String statusDescription,
        String message,
        String description
) {
}
