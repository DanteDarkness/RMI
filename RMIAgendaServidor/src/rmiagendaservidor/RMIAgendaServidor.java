/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiagendaservidor;
import java.rmi.registry.*;
import common.agenda.*;
import common.callback.*;
import common.dummy.*;


/**
 *
 * @author rafa_
 */
public class RMIAgendaServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //TODO: Crear el Registry de RMI
            System.out.println("iniciando....");
            LocateRegistry.createRegistry(1099);
            Agenda agenda= new Agenda();
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("agenda", agenda);
            System.out.println("servidor listo...");
            //TODO: Obtener el Registry y hacer un bind del objeto remoto con su nombre lógico 
        } catch (Exception ex){
            System.out.println("Error en el servidor: " + ex);
        }
    }
    
}

