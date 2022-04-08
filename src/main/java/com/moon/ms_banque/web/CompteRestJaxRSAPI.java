package com.moon.ms_banque.web;


import com.moon.ms_banque.MsBanqueApplication;
import com.moon.ms_banque.entities.Compte;
import com.moon.ms_banque.repository.CompteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


//Utilisation de la bibliotheque JaxRS
//Creation d'un controller avec JaxRS

@Path("/banque")
@Component
public class CompteRestJaxRSAPI {


    //=== constants ===
    private static final Logger log = LoggerFactory.getLogger(CompteRestJaxRSAPI.class);

        @Autowired
        private CompteRepository compteRepository;


        @Path("/comptes")
        @GET
        @Produces({MediaType.APPLICATION_JSON})
        public List<Compte> compteList(){
            log.info("=== Appel de la liste des différents comptes ===");
            return  compteRepository.findAll();
        }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id){

        log.info("=== consulte un compte  {} ",id);
          return   compteRepository.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        log.info("===Creation d'un nouveau compte {} ",compte);
        return compteRepository.save(compte);
    }



    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte,@PathParam("id") Long id){
            compte.setId(id);
        log.info("=== Mise a jour d'un compte {} - {}",compte, id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){
        log.info("=== Suppression du compte numero {} ",id);
        compteRepository.deleteById(id);
    }

}
