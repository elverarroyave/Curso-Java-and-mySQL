/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import controller.CtrlProducto;
import model.ConsultasProductos;
import model.Producto;
import view.frmProducto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto mod = new Producto();
        ConsultasProductos modC = new ConsultasProductos();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
