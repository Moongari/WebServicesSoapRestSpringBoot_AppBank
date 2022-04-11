package com.moon.ms_banque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement // utiliser cette annotation pour le protocole SOAP JaxWS
@XmlAccessorType(XmlAccessType.FIELD) // ce qui veut dire que les annotations jaxB agissent sur les attributs et non pas les getters et setters
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //== par defaut le chargement des données est lazy ==
    //== ainsi les données du compte ne sont pas chargés
    //== la connection est fermé des la recuperation des données du client et ne charge pas la liste des comptes.
    //== pour cela il faut utiliser eager mais attention cela implique des charges des données donc on a pas besoin forcement.
    @OneToMany(mappedBy = "client")
    @XmlTransient // l'appel d'un client va generer une boucle infini entre le compte et le client pour cela il faut declarer cette annotation.
    Collection<Compte> comptes;

}
