package com.moon.ms_banque.web;


import com.moon.ms_banque.entities.Compte;
import com.moon.ms_banque.repository.CompteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


//Utilisation de la bibliotheque JaxRS
//Creation d'un controller avec JaxRS

@WebService(serviceName = "BanqueWS") //ici on utilise jaxWS et non pas spring
@Component // il faut declarer ceci comme un composant
public class CompteSoapService {


    //=== constants ===
    private static final Logger log = LoggerFactory.getLogger(CompteSoapService.class);

        @Autowired
        private CompteRepository compteRepository;


       @WebMethod
        public List<Compte> compteList(){
            log.info("=== Appel de la liste des différents comptes ===");
            return  compteRepository.findAll();
        }


    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id){

        log.info("=== consulte un compte  {} ",id);
          return   compteRepository.findById(id).get();
    }

    @WebMethod
    public Compte save(Compte compte){
        log.info("===Creation d'un nouveau compte {} ",compte);
        return compteRepository.save(compte);
    }



   @WebMethod
    public Compte update(Compte compte,@WebParam(name = "id") Long id){
            compte.setId(id);
        log.info("=== Mise a jour d'un compte {} - {}",compte, id);
        return compteRepository.save(compte);
    }

    @WebMethod
    public void delete(@WebParam(name = "id") Long id){
        log.info("=== Suppression du compte numero {} ",id);
        compteRepository.deleteById(id);
    }

}
