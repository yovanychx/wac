/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.casos.tpi.mb;

import com.casos.ues.tpi.casosacadues.lib.Requisito;
import com.casos.ues.tpi.casosacadues.lib.TipoPaso;
import com.casos.ues.tpi.casosacadues.lib.TipoRequisito;
import com.uesocc.casos.tpi.beans.RequisitoFacadeLocal;
import com.uesocc.casos.tpi.beans.TipoRequisitoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author yovany
 */
@Named(value = "frmRequisito")
@ViewScoped
public class frmRequisito implements Serializable{
    @EJB
    private RequisitoFacadeLocal ejbRequisito;
    private TipoRequisitoFacadeLocal ejbTRequisito;
    private LazyDataModel<Requisito> tabla;
    private Requisito registro;
    private String message;
    private boolean btnGuardar = true;
    private boolean btnBorrarModificar =false;
    private boolean frmEdit;
    
    @PostConstruct
    private void CargarTabla(){        
        registro = new Requisito();        
        try {            
            tabla = new LazyDataModel<Requisito>() {
                @Override
                public Object getRowKey(Requisito object){
                    if(object != null){
                        return object.getIdRequisito();
                    }
                    return null;
                }
                
                @Override
                public  Requisito getRowData(String rowKey){
                    if(rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null){
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Requisito requisito : (List<Requisito>) getWrappedData()) {
                                if(requisito.getIdRequisito().compareTo(buscado)  == 0){
                                    return requisito;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }
                
                @Override
                public List<Requisito> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Requisito> salida = new ArrayList();
                    try {
                        if (ejbRequisito != null) {
                            this.setRowCount(ejbRequisito.count());
                            salida = ejbRequisito.findRange(first, pageSize);
                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }
            };            
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }    
    }
    
    public void Guardar() {
        try {
            if (this.registro != null && this.ejbRequisito != null) {                
                this.ejbRequisito.create(registro);
                setMessage("Registro creado con éxito");
                sendMessage();
                this.registro = new Requisito();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }

    public void Eliminar() {
        try {            
            if (this.registro != null && this.ejbRequisito != null) {
                this.ejbRequisito.remove(registro);
                setMessage("Registro eliminado con éxito");
                sendMessage();
                btnBorrarModificar = false;
                btnGuardar = true;
                this.registro = new Requisito();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }
    
    public void Modificar() {
        try {            
            if (this.registro != null && this.ejbRequisito != null) {
                this.ejbRequisito.edit(registro);
                setMessage("Registro modificado con éxito");
                sendMessage();
                btnBorrarModificar = false;
                btnGuardar = true;
                this.registro = new Requisito();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }
    
    public void cambiarSeleccion(SelectEvent se){
        if(se.getObject() != null){
            try {
                this.registro = new Requisito();
                this.registro = (Requisito) se.getObject();
                frmEdit = true;
                btnBorrarModificar = true;
                btnGuardar = false;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                System.out.println("Error " + e);
            }
        }
    }
    
    public void mostrar() {
        this.frmEdit = true;
        this.btnGuardar = true;
        btnBorrarModificar = false;
        this.registro = new Requisito();
    }
    
    public void ocultar() {
        this.frmEdit = false;
        this.registro = new Requisito();
    }
    
    public TipoRequisito Borrar(TipoRequisito t){
        return ejbRequisito.find(t).getIdTipoRequisito();
    }
    
    public LazyDataModel<Requisito> getTabla() {
        return tabla;
    }

    public void setModelo(LazyDataModel<Requisito> tabla) {
        this.tabla = tabla;
    }

    public Requisito getRegistro() {
        return registro;
    }

    public void setRegistro(Requisito registro) {
        this.registro = registro;
    }
     public frmRequisito(){
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void sendMessage() {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage(message) );
    }
  
    public boolean isBtnGuardar() {
        return btnGuardar;
    }
    
    public void setBtnGuardar(boolean btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public boolean isBtnBorrarModificar() {
        return btnBorrarModificar;
    }

    public void setBtnBorrarModificar(boolean btnBorrarModificar) {
        this.btnBorrarModificar = btnBorrarModificar;
    }

    public boolean isFrmEdit() {
        return frmEdit;
    }

    public void setFrmEdit(boolean frmEdit) {
        this.frmEdit = frmEdit;
    }
    
}
