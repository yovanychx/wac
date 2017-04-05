package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.Caso;
import com.casos.ues.tpi.casosacadues.lib.CasoDetalleRequisito;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(CasoDetalle.class)
public class CasoDetalle_ { 

    public static volatile SingularAttribute<CasoDetalle, Integer> idCasoDetalle;
    public static volatile SingularAttribute<CasoDetalle, Date> fecha;
    public static volatile SingularAttribute<CasoDetalle, String> estado;
    public static volatile SingularAttribute<CasoDetalle, Caso> idCaso;
    public static volatile ListAttribute<CasoDetalle, CasoDetalleRequisito> casoDetalleRequisitoList;
    public static volatile SingularAttribute<CasoDetalle, Integer> idProcesDetalle;

}