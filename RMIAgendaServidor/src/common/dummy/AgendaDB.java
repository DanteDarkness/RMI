/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dummy;
import common.agenda.RegistroAgenda;
import java.util.ArrayList;
/**
 *
 * @author rafa_
 */
public class AgendaDB {
    private ArrayList<RegistroAgenda> _agenda;
    
    public AgendaDB() {
        _agenda = new ArrayList<>();
    }
    
    public RegistroAgenda insertar(RegistroAgenda registro) {
        RegistroAgenda nuevoRegistro;
        nuevoRegistro = new RegistroAgenda(_agenda.size()+1, registro.getNombre(), registro.getTelefono());
        _agenda.add(nuevoRegistro);
        return nuevoRegistro;
    }
}
