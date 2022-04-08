package com.moon.ms_banque.repository;

import com.moon.ms_banque.entities.Compte;
import com.moon.ms_banque.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//=== utilisation de Spring Data Rest =====
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long>
{
    //== on peut rechercher cela de cette facon
    //== http://localhost:8082/api/comptes/search/findByType?type=COURANT grace spring Data Rest==
    List<Compte> findByType(TypeCompte type);

}
