package br.com.munhosdev.food_make_happy.client;

import br.com.munhosdev.food_make_happy.domain.dto.response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EnderecoClient", url = "${feign.url.cep}")
public interface EnderecoClient {

    @GetMapping("/{cep}")
    public EnderecoResponse getEndereco(@PathVariable String cep);
}
