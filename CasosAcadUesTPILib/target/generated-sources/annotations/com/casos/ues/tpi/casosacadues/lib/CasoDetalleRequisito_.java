package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.CasoDetalle;
import com.casos.ues.tpi.casosacadues.lib.DbCdra;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(CasoDetalleRequisito.class)
public class CasoDetalleRequisito_ { 

    public static volatile SingularAttribute<CasoDetalleRequisito, Integer> idCDR;
    public static volatile SingularAttribute<CasoDetalleRequisito, CasoDetalle> idCasoDetalle;
    public static volatile SingularAttribute<CasoDetalleRequisito, Date> fecha;
    public static volatile SingularAttribute<CasoDetalleRequisito, Integer> idPasoRequisito;
    public static volatile SingularAttribute<CasoDetalleRequisito, String> estadoRequisito;
    public static volatile ListAttribute<CasoDetalleRequisito, DbCdra> dbCdraList;

}