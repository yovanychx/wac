/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.casos.tpi.mb;

import com.casos.ues.tpi.casosacadues.lib.TipoRequisito;
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

@Named(value = "frmTipoRequisito")
@ViewScoped
public class frmTipoRequisito implements Serializable{
      
    @EJB
    private TipoRequisitoFacadeLocal ejbTipoRequisito;
    private LazyDataModel<TipoRequisito> tabla;
    private TipoRequisito registro;
    private String message;
    private boolean btnGuardar = true;
    private boolean btnBorrarModificar =false;
    private boolean frmEdit;
    
    @PostConstruct
    private void CargarTabla(){        
        registro = new TipoRequisito();        
        try {            
            tabla = new LazyDataModel<TipoRequisito>() {
                @Override
                public Object getRowKey(TipoRequisito object){
                    if(object != null){
                        return object.getIdTipoRequisito();
                    }
                    return null;
                }
                
                @Override
                public  TipoRequisito getRowData(String rowKey){
                    if(rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null){
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (TipoRequisito tiporequisito : (List<TipoRequisito>) getWrappedData()) {
                                if(tiporequisito.getIdTipoRequisito().compareTo(buscado)  == 0){
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
                public List<TipoRequisito> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<TipoRequisito> salida = new ArrayList();
                    try {
                        if (ejbTipoRequisito != null) {
                            this.setRowCount(ejbTipoRequisito.count());
                            salida = ejbTipoRequisito.findRange(first, pageSize);
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
            if (this.registro != null && this.ejbTipoRequisito != null) {                
                this.ejbTipoRequisito.create(registro);
                setMessage("Registro creado con éxito");
                sendMessage();
                this.registro = new TipoRequisito();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }

    public void Eliminar() {
        try {            
            if (this.registro != null && this.ejbTipoRequisito != null) {
                this.ejbTipoRequisito.remove(registro);
                setMessage("Registro eliminado con éxito");
                sendMessage();
                btnBorrarModificar = false;
                btnGuardar = true;
                this.registro = new TipoRequisito();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }
    
    public void Modificar() {
        try {            
            if (this.registro != null && this.ejbTipoRequisito != null) {
                this.ejbTipoRequisito.edit(registro);
                setMessage("Registro modificado con éxito");
                sendMessage();
                btnBorrarModificar = false;
                btnGuardar = true;
                this.registro = new TipoRequisito();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            System.out.println("Error " + ex);
        }
    }
    
    public void cambiarSeleccion(SelectEvent se){
        if(se.getObject() != null){
            try {
                this.registro = new TipoRequisito();
                this.registro = (TipoRequisito) se.getObject();
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
        this.registro = new TipoRequisito();
    }
    
    public void ocultar() {
        this.frmEdit = false;
        this.registro = new TipoRequisito();
    }
    
    public List<TipoRequisito> findAll(){
       return ejbTipoRequisito.findAll();
    }
    
    public String Devolver(TipoRequisito tipo){
        return tipo.getNombre();
    }
    
    public LazyDataModel<TipoRequisito> getTabla() {
        return tabla;
    }

    public void setModelo(LazyDataModel<TipoRequisito> tabla) {
        this.tabla = tabla;
    }

    public TipoRequisito getRegistro() {
        return registro;
    }

    public void setRegistro(TipoRequisito registro) {
        this.registro = registro;
    }
     public frmTipoRequisito(){
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
