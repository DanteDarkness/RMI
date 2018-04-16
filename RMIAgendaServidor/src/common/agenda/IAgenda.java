/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.agenda;
import java.rmi.*;
import common.callback.*;
/**
 *
 * @author rafa_
 */
public interface IAgenda extends Remote {
    public RegistroAgenda agregarRegistro(RegistroAgenda registro) throws RemoteException;
    public void registrarCallback(IAgendaCallback callback) throws RemoteException;
}
