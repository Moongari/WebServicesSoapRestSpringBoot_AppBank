package com.moon.ms_banque;

import com.moon.ms_banque.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigJersey {


        //=== creation du dispatcherServlet via Jersey ===
        //=== au demarrage de l'application springboot fait appel a ce dispatcher ===
        @Bean
        public ResourceConfig resourceConfig(){
            ResourceConfig jerseyServlet = new ResourceConfig();
            jerseyServlet.register(CompteRestJaxRSAPI.class);
            return  jerseyServlet;
        }

}
