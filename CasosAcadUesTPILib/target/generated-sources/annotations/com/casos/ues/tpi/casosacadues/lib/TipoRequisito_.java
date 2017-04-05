package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.Requisito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(TipoRequisito.class)
public class TipoRequisito_ { 

    public static volatile SingularAttribute<TipoRequisito, String> observaciones;
    public static volatile SingularAttribute<TipoRequisito, Integer> idTipoRequisito;
    public static volatile SingularAttribute<TipoRequisito, String> nombre;
    public static volatile ListAttribute<TipoRequisito, Requisito> requisitoList;
    public static volatile SingularAttribute<TipoRequisito, Boolean> activo;

}