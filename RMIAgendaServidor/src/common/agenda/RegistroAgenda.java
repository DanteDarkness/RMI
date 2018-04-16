/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.agenda;

import java.io.Serializable;
/**
 *
 * @author rafa_
 */
//Clase RegistroAgenda. Contiene campos de ID, Nombre y Teléfono.
public class RegistroAgenda implements Serializable {
    private String _nombre;
    private String _telefono;
    private int _ID;
    
    public RegistroAgenda(String nombre, String telefono){
        _nombre = nombre;
        _telefono = telefono;
        _ID = 0;
    }
    
    public RegistroAgenda(int ID, String nombre, String telefono){
        _nombre = nombre;
        _telefono = telefono;
        _ID = ID;
    }
    
    public String getNombre() {return _nombre;}
    public void setNombre(String nombre) { _nombre = nombre;}
    
    public String getTelefono() {return _telefono;}
    public void setTelefono(String telefono){ _telefono = telefono; }
    
    public int getID() { return _ID;}
}
