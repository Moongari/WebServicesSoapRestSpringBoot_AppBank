package com.moon.ms_banque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Compte {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING) // l'attribut sera de type numerique par defaut dans la BDD
    @Column(length = 10)
    private TypeCompte type;
}
