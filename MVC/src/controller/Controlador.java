/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Modelo;
import view.Vista;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador implements ActionListener{
    
    
    private Vista view;
    private Modelo model;
    
    public Controlador(Vista view, Modelo model){
        this.view=view;
        this.model=model;
        
        this.view.btnMultiplicar.addActionListener(this);
    }
    
    
    public void iniciar(){
        view.setTitle("MVC Multiplicar");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        model.setNumeroUno(Integer.parseInt(view.txtNumero1.getText()));
        
        model.setNumeroDos(Integer.parseInt(view.txtNumero2.getText()));
        
        model.multiplicar();
        
        view.txtResultado.setText(""+model.getResultado());
    }
    
    
    
}
