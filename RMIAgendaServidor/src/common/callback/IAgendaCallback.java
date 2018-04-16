/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.callback;
import common.agenda.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author rafa_
 */
public interface IAgendaCallback extends Remote {
    public String notificar(RegistroAgenda registro) throws RemoteException;
}