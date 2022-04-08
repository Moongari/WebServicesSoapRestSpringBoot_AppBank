package com.moon.ms_banque.repository;

import com.moon.ms_banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long>
{

}
