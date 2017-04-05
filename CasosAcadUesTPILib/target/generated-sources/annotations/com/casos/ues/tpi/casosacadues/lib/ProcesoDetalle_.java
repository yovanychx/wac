package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.Paso;
import com.casos.ues.tpi.casosacadues.lib.Proceso;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(ProcesoDetalle.class)
public class ProcesoDetalle_ { 

    public static volatile SingularAttribute<ProcesoDetalle, Integer> idProcesoDetalle;
    public static volatile SingularAttribute<ProcesoDetalle, Integer> indice;
    public static volatile SingularAttribute<ProcesoDetalle, Paso> idPaso;
    public static volatile SingularAttribute<ProcesoDetalle, Proceso> idProceso;

}