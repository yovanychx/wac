package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.CasoDetalle;
import com.casos.ues.tpi.casosacadues.lib.Proceso;
import com.casos.ues.tpi.casosacadues.lib.Solicitudes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(Caso.class)
public class Caso_ { 

    public static volatile SingularAttribute<Caso, Integer> idCaso;
    public static volatile ListAttribute<Caso, CasoDetalle> casoDetalleList;
    public static volatile SingularAttribute<Caso, Solicitudes> idSolicitud;
    public static volatile SingularAttribute<Caso, Proceso> idProceso;

}