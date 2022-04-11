package com.moon.ms_banque;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfigSoap {



    //deploiement WebService en utilisant JaxWS en utilisant SimpleJaxWSServiceExporter
    // il existe d'autres moyen de le faire. cette facon est la plus simple.

    @Bean
    SimpleJaxWsServiceExporter serviceExporter (){

        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8889/");
        return  serviceExporter;
    }

}
