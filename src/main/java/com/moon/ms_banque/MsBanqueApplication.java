package com.moon.ms_banque;

import com.moon.ms_banque.entities.Client;
import com.moon.ms_banque.entities.Compte;
import com.moon.ms_banque.entities.TypeCompte;
import com.moon.ms_banque.repository.ClientRepository;
import com.moon.ms_banque.repository.CompteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class MsBanqueApplication {



    //=== constants ===
    private static final Logger log = LoggerFactory.getLogger(MsBanqueApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(MsBanqueApplication.class, args);
    }




    //== exposer l'id avec spring data Rest
    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration restConfiguration, ClientRepository clientRepository)
    {
        restConfiguration.exposeIdsFor(Compte.class);
       return args->{
            log.info("=== Affichage et test de la base de données ==== ");
            Client c1 =clientRepository.save(new Client(null,"Moustafa",null));
            Client c2 =clientRepository.save(new Client(null,"Albert",null));
            Client c3 = clientRepository.save(new Client(null,"younes",null));

           compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT,c1));
           compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPARGNE,c2));
           compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT,c3));

           compteRepository.findAll().forEach(c-> {

               System.out.println("Solde :"+c.getSolde()+"Client :" + c.getDateCreation());

           });

        };

    }

}
