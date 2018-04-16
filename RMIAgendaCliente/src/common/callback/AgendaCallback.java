/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.callback;
import common.agenda.RegistroAgenda;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author rafa_
 */
public class AgendaCallback extends UnicastRemoteObject
        implements IAgendaCallback{
    
    public AgendaCallback() throws RemoteException {
        super();
    }
        //TODO: Implementar método notificar.
    //      Este método recibe como parámetro un objeto de tipo RegistroAgenda
    //      El método debe devolver una cadena conteniendo el ID del registro que se insertó.
    //      También debe imprimirlo en consola

    @Override
    public String notificar(RegistroAgenda registro) throws RemoteException {
      String ID="El Id registrado es "+registro.getID();
      System.out.println(ID);
        return ID;
    }
}
