/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.casos.tpi.ws;

import java.util.Set;
import javax.ws.rs.core.Application;


/**
 *
 * @author yovany
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
//                addRestResourceClasses(resources);
        resources.add(TipoRequisitoRest.class);
        resources.add(TipoPasoRest.class);
        return resources;
    }
    
    
     private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(com.uesocc.casos.tpi.ws.TipoPasoRest.class);
        resources.add(com.uesocc.casos.tpi.ws.TipoRequisitoRest.class);
    }
    
}
