/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creda_league;

/**
 *
 * @author Pratik Awasthi
 */
import java.io.InputStream;
import java.rmi.*;
//Remote Interface
public interface creda_interface extends Remote{
    public String user_info(String username,String phoneno,String email,String passsword, String filename) throws RemoteException;
    public String user_login(String phone,String password) throws RemoteException;
    public String admin_add_team(String teamname,String filename_image) throws RemoteException;
    public String admin_add_player(String playername,String playerteam,String player_type,String filename_image)throws RemoteException;
    public String[] team_details() throws RemoteException;
    public String transaction_entry(String phoneno,String amount,String total_amount)throws RemoteException;
    public Object getUserDetails(String phoneno) throws RemoteException;
}
