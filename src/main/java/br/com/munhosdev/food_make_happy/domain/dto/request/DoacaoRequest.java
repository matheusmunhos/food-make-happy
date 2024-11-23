package br.com.munhosdev.food_make_happy.domain.dto.request;

import java.time.LocalDate;

public record DoacaoRequest(String alimento,
                            Integer quantidade,
                            LocalDate validade,
                            Boolean lacrado,
                            Double valorEstimado,
                            String doadorCpfCnpj,
                            String recptorCpfCnpj) {
}
