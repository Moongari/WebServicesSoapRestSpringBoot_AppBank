package com.moon.ms_banque.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile",types =Compte.class)
public interface Projection2 {

     double getSolde();
     TypeCompte getType();
}
