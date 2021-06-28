/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veronica;

/**
 *
 * @author Pratik Awasthi
 */
import java.rmi.*;
public interface veronica_interface extends Remote {
    public String user_chat(String message) throws RemoteException;
}
