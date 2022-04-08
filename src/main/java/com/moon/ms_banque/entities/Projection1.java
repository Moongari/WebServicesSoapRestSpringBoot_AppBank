package com.moon.ms_banque.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde",types =Compte.class)
public interface Projection1 {

    public double getSolde();
}


