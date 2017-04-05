package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.Caso;
import com.casos.ues.tpi.casosacadues.lib.ProcesoDetalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(Proceso.class)
public class Proceso_ { 

    public static volatile SingularAttribute<Proceso, String> descripcion;
    public static volatile ListAttribute<Proceso, Caso> casoList;
    public static volatile ListAttribute<Proceso, ProcesoDetalle> procesoDetalleList;
    public static volatile SingularAttribute<Proceso, Integer> idProceso;
    public static volatile SingularAttribute<Proceso, String> nombre;

}