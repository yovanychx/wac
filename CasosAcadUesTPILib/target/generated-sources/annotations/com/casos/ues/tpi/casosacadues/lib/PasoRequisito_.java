package com.casos.ues.tpi.casosacadues.lib;

import com.casos.ues.tpi.casosacadues.lib.Paso;
import com.casos.ues.tpi.casosacadues.lib.Requisito;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T09:53:31")
@StaticMetamodel(PasoRequisito.class)
public class PasoRequisito_ { 

    public static volatile SingularAttribute<PasoRequisito, Integer> idPasoRequisito;
    public static volatile SingularAttribute<PasoRequisito, Integer> indice;
    public static volatile SingularAttribute<PasoRequisito, Paso> idPaso;
    public static volatile SingularAttribute<PasoRequisito, Requisito> idRequisito;

}