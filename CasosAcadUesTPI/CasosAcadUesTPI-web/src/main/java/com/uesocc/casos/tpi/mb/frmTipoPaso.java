/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.casos.tpi.mb;

import com.casos.ues.tpi.casosacadues.lib.TipoPaso;
import com.uesocc.casos.tpi.beans.TipoPasoFacadeLocal;
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
@Named(value = "frmTipoPaso")
@ViewScoped
public class frmTipoPaso implements Serializable{
    @EJB
    private TipoPasoFacadeLocal ejbTipoPaso;
    private LazyDataModel<TipoPaso> tabla;
    private TipoPaso registro;
    private String message;
    private boolean btnGuardar = true;
    private boolean btnBorrarModificar =false;
    private boolean frmEdit;
    
    @PostConstruct
    private void CargarTabla(){        
        registro = new TipoPaso();        
        try {            
            tabla = new LazyDataModel<TipoPaso>() {
                @Override
                public Object getRowKey(TipoPaso object){
                    if(object != null){
                        return object.getIdTipoPaso();
                    }
                    return null;
                }
                
                @Override
                public  TipoPaso getRowData(String rowKey){
                    if(rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null){
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (TipoPaso tiporequisito : (List<TipoPaso>) getWrappedData()) {
                                if(tiporequisito.getIdTipoPaso().compareTo(buscado)  == 0){
                                    return tiporequisito;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }
                
                @Override
                public List<TipoPaso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<TipoPaso> salida = new ArrayList();
                    try {
                        if (ejbTipoPaso != null) {
                            this.setRowCount(ejbTipoPaso.count());
                            salida = ejbTipoPaso.findRange(first, pageSize);
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
            if (this.registro != null && this.ejbTipoPaso != null) {                
                this.ejbTipoPaso.create(registro);
                setMessage("Registro creado con éxito");
                sendMessage();
                this.registro = new TipoPaso();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }

    public void Eliminar() {
        try {            
            if (this.registro != null && this.ejbTipoPaso != null) {
                this.ejbTipoPaso.remove(registro);
                setMessage("Registro eliminado con éxito");
                sendMessage();
                btnBorrarModificar = false;
                btnGuardar = true;
                this.registro = new TipoPaso();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }
    
    public void Modificar() {
        try {            
            if (this.registro != null && this.ejbTipoPaso != null) {
                this.ejbTipoPaso.edit(registro);
                setMessage("Registro modificado con éxito");
                sendMessage();
                btnBorrarModificar = false;
                btnGuardar = true;
                this.registro = new TipoPaso();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }
    
    public void cambiarSeleccion(SelectEvent se){
        if(se.getObject() != null){
            try {
                this.registro = new TipoPaso();
                this.registro = (TipoPaso) se.getObject();
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
        this.registro = new TipoPaso();
    }
    
    public void ocultar() {
        this.frmEdit = false;
        this.registro = new TipoPaso();
    }
    
    public LazyDataModel<TipoPaso> getTabla() {
        return tabla;
    }

    public void setModelo(LazyDataModel<TipoPaso> tabla) {
        this.tabla = tabla;
    }

    public TipoPaso getRegistro() {
        return registro;
    }

    public void setRegistro(TipoPaso registro) {
        this.registro = registro;
    }
     public frmTipoPaso(){
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
