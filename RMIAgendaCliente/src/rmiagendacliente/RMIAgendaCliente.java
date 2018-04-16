/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiagendacliente;

import java.io.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import common.callback.*;
import common.agenda.*;
import java.util.Scanner;

/**
 *
 * @author rafa_
 */
public class RMIAgendaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, InterruptedException {
        IAgenda agenda;
        boolean validador;
        String ciclo = "";
        String callbackClass = "common.callback.AgendaCallback";
        int registros_num;
        Scanner reader = new Scanner(System.in);
        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(input);
            Registry registry = LocateRegistry.getRegistry();                   //Listo
            agenda = (IAgenda) registry.lookup("agenda");                       //listo
            IAgendaCallback callback = (IAgendaCallback) Class.forName(callbackClass).newInstance();            //Listo
            agenda.registrarCallback(callback);                                                                 //Listo
            do {
                System.out.println("¿Cuantos registros desea agregar?");
                String registros = reader.nextLine();
                if (isNumeric(registros)) {
                    registros_num = Integer.parseInt(registros);
                    while (registros_num>0) {
                        System.out.println("¿Cual es el nombre?");
                        String nombre = br.readLine();
                        System.out.println("¿Cual es el numero telefonico?");
                        String numero = br.readLine();
                        RegistroAgenda registro = null;
                        registro.setNombre(nombre);
                        registro.setTelefono(numero);
                        agenda.agregarRegistro(registro);       
                        registros_num--;
                    }
                } else {
                    System.out.println("No elegiste ningun numero un numero");
                    registros = reader.nextLine();
                }
                System.out.println("¿Desea agregar mas registros S/N?");
                ciclo = reader.nextLine();
            } while (ciclo.equals("S") || ciclo.equals("s"));
        } catch (Exception ex) {
            System.out.println("Aqui esta  ***** ** ** ** ** Error" + ex.getMessage());
        }
        Thread.sleep(5000);
    }

    
    
        //TODO: Obtener el Registry y hacer lookup al método remoto
        //TODO: Registrar el callback en el servidor
        //TODO: Pedir el nombre y número de teléfono a registrar.
        //      Para permitir ingresar varios registros, debe existir un ciclo.
        //      Se debe preguntar al cliente si desea realizar otro registro, en caso negativo terminar el programa
        //El hilo principal lo detenemos 5 segundos para simular tiempo de espera...
    
    
    
    
    
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
