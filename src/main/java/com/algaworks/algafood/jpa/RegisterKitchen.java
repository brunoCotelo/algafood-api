package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Kitchen;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RegisterKitchen {

    @PersistenceContext
    private EntityManager manager;

    public List<Kitchen> list(){
        return manager.createQuery("from Kitchen", Kitchen.class)
                        .getResultList();
    }
}
