/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.casos.tpi.beans;

import com.casos.ues.tpi.casosacadues.lib.CasoDetalleRequisito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yovany
 */
@Stateless
public class CasoDetalleRequisitoFacade extends AbstractFacade<CasoDetalleRequisito> implements CasoDetalleRequisitoFacadeLocal {

    @PersistenceContext(unitName = "com.uesocc.casos.tpi_CasosAcadUesTPI-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasoDetalleRequisitoFacade() {
        super(CasoDetalleRequisito.class);
    }
    
}
