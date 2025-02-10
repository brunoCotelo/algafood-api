package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Kitchen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@Slf4j
public class ConsultKitchenMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RegisterKitchen registerKitchen = applicationContext.getBean(RegisterKitchen.class);

        List<Kitchen> list = registerKitchen.list();

        list.forEach(kitchen -> log.info(kitchen.getName()));

        Kitchen kitchen1 = new Kitchen();
        kitchen1.setName("Teste1");
        Kitchen kitchen2 = new Kitchen();
        kitchen2.setName("Teste2");


        kitchen1 = registerKitchen.save(kitchen1);
        kitchen2 = registerKitchen.save(kitchen2);

        log.info("Kitchen1 saved with id: {}", kitchen1.getId());
        log.info("Kitchen2 saved with id: {}", kitchen2.getId());
    }
}
