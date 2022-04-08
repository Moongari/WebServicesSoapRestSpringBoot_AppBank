package com.moon.ms_banque.web;


import com.moon.ms_banque.entities.Compte;
import com.moon.ms_banque.repository.CompteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.MediaType.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


//Utilisation de la bibliotheque RestController


@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {


    //=== constants ===
    private static final Logger log = LoggerFactory.getLogger(CompteRestControllerAPI.class);

        @Autowired
        private CompteRepository compteRepository;


        @Path("/comptes")
        @GetMapping(path = "/comptes",produces = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})

        public List<Compte> compteList(){
            log.info("=== Appel de la liste des différents comptes ===");
            return  compteRepository.findAll();
        }


        //== on definit different type de retour json et XML ===

    @GetMapping(path = "/comptes/{id}")
    public Compte getOne(@PathVariable(value = "id") Long id){

        log.info("=== consulte un compte  {} ",id);
          return   compteRepository.findById(id).get();
    }


    @PostMapping(path = "/comptes")
    public Compte save(@RequestBody Compte compte){
        log.info("===Creation d'un nouveau compte {} ",compte);
        return compteRepository.save(compte);
    }




    @PutMapping(path = "/comptes/{id}")
    public Compte update(@RequestBody Compte compte,@PathVariable("id") Long id){
            compte.setId(id);
        log.info("=== Mise a jour d'un compte {} - {}",compte, id);
        return compteRepository.save(compte);
    }


    @DeleteMapping(path = "/comptes/{id}")
    public void delete(@PathVariable("id") Long id){
        log.info("=== Suppression du compte numero {} ",id);
        compteRepository.deleteById(id);
    }

}
