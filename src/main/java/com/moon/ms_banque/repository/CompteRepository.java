package com.moon.ms_banque.repository;

import com.moon.ms_banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//=== utilisation de Spring Data Rest =====
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long>
{

}
