package common.agenda;

import common.agenda.RegistroAgenda;
import common.callback.IAgendaCallback;
import common.dummy.AgendaDB;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
/**
 *
 * @author rafa_
 */
public class Agenda extends UnicastRemoteObject
    implements IAgenda {    
    private AgendaDB _db;
    private Vector _clientes;
    public Agenda() throws RemoteException {
        super();
        _db = new AgendaDB();
        _clientes = new Vector();
    }
    
    private synchronized void lanzarCallbacks(RegistroAgenda registro) throws RemoteException {
               for (int i = 0; i < _clientes.size(); i++) {
            IAgendaCallback cliente = (IAgendaCallback) _clientes.elementAt(i);
            cliente.notificar(registro);
        }
        
    }

    //TODO: Implementar el método agregarRegistro
    @Override
    public RegistroAgenda agregarRegistro(RegistroAgenda registro) throws RemoteException {
    _db.insertar(registro);
        return registro;
    }
    //public .....
        //TODO: Simular el registro en BD usando la clase AgendaDB 
        //      Notificar a los clientes que se ha insertado un nuevo registro
        
    //TODO: Implementar el método registrarCallback
    @Override
    public void registrarCallback(IAgendaCallback callback) throws RemoteException {
        if(!_clientes.contains(callback)){
        _clientes.addElement(callback);
    }}
    
}

