package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.PasoRequisito;
import com.casos.ues.tpi.casosacadues.lib.TipoRequisito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(Requisito.class)
public class Requisito_ { 

    public static volatile SingularAttribute<Requisito, String> descripcion;
    public static volatile ListAttribute<Requisito, PasoRequisito> pasoRequisitoList;
    public static volatile SingularAttribute<Requisito, Integer> idRequisito;
    public static volatile SingularAttribute<Requisito, String> nombre;
    public static volatile SingularAttribute<Requisito, TipoRequisito> idTipoRequisito;
    public static volatile SingularAttribute<Requisito, String> prioridad;

}