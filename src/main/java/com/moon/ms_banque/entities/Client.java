package com.moon.ms_banque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //== par defaut le chargement des données est lazy ==
    //== ainsi les données du compte ne sont pas chargés
    //== la connection est fermé des la recuperation des données du client et ne charge pas la liste des comptes.
    //== pour cela il faut utiliser eager mais attention cela implique des charges des données donc on a pas besoin forcement.
    @OneToMany(mappedBy = "client")
    Collection<Compte> comptes;

}
