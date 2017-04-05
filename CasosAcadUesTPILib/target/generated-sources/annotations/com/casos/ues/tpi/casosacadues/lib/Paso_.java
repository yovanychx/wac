package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.PasoRequisito;
import com.casos.ues.tpi.casosacadues.lib.ProcesoDetalle;
import com.casos.ues.tpi.casosacadues.lib.TipoPaso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(Paso.class)
public class Paso_ { 

    public static volatile SingularAttribute<Paso, String> descripcion;
    public static volatile SingularAttribute<Paso, TipoPaso> idTipoPaso;
    public static volatile SingularAttribute<Paso, String> tiempo;
    public static volatile ListAttribute<Paso, PasoRequisito> pasoRequisitoList;
    public static volatile SingularAttribute<Paso, Integer> idPaso;
    public static volatile ListAttribute<Paso, ProcesoDetalle> procesoDetalleList;

}