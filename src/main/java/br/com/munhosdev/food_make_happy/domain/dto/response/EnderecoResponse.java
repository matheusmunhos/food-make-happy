package br.com.munhosdev.food_make_happy.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;

public record EnderecoResponse(
        String cep,
        @JsonAlias("address_type")
        String addressType,
        @JsonAlias("address_name")
        String addressName,
        String address,
        String state,
        String district,
        double lat,
        double lng,
        String city,
        @JsonAlias("city_ibge")
        String cityIbge,
        String ddd
) {
}
