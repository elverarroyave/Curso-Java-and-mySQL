/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ConsultasProductos;
import model.Producto;
import view.frmProducto;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CtrlProducto implements ActionListener{
    
    private Producto mod;
    private ConsultasProductos modC;
    private frmProducto frm;
    
    public CtrlProducto(Producto mod, ConsultasProductos modC, frmProducto frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        
        
    }
    
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtIdTemporal.setVisible(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == frm.btnGuardar){
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
        if(e.getSource() == frm.btnModificar){
            mod.setId(Integer.parseInt(frm.txtIdTemporal.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
        
        if(e.getSource() == frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.txtIdTemporal.getText()));
            
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        }
        
        if(e.getSource() == frm.btnBuscar){
            mod.setCodigo(frm.txtCodigo.getText());
            
            
            if(modC.buscar(mod)){
                
                frm.txtIdTemporal.setText(""+mod.getId());
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(""+mod.getPrecio());
                frm.txtCantidad.setText(""+mod.getCantidad());
              
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el resultado");
            }
        }
        
        if(e.getSource() == frm.btnLimpiar){
            limpiar();
        }
            
        
    }
    
    public void limpiar(){
        frm.txtIdTemporal.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
        
    }
}
